
import java.awt.*;

public class AlphaBlending6 {

	static MyImage execute(MyImage input1, MyImage input2, MyImage input0) { 

		int width1 = input1.width;
		int width2 = input2.width;
		int height1 = input1.height;
		int height2 = input2.height;
	
		int width  = (width1  > width2)  ? width1  : width2;//true:false
		int height = (height1 > height2) ? height1 : height2;
	
		MyImage output = new MyImage(width, height);

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				boolean isProcessed = false;
                int a=455,b=290;//ずらす分だけ
                

				// 画素がinput1の内部か確認
                if(b<i && i < (height1+b) && a< j &&j < (width1+a)) {

					// 切り取った部分input0の画素が黒(0,0,0)かどうか確認
					Color color0 = input0.getColor(j-a, i-b);
                    if(color0.getRed() > 0) {
						//itotならば
                        //itotであるあいだのみ、color3を出力したい
						// 黒でない場合には、38~39 行目にて、input1 の画素値を output に代入
                        if(i<height2 &&j<width2){
                        
						Color color1 = input1.getColor(j-a, i-b);
						 Color color2 = input2.getColor(j-30, i);//移動先の画素値を持ってくる

						int valueR = 0; 
						int valueG = 0;
						int valueB = 0;
						valueR += (int)((color1.getRed()*0.5)+color2.getRed()*0.5);
						valueG += (int)((color1.getGreen()*0.5)+color2.getGreen()*0.5);
						valueB += (int)((color1.getBlue()*0.5)+color2.getBlue()*0.5);
						Color color3 = new Color((int)valueR, (int)valueG, (int)valueB);
						
						output.setColor(width-j-630, i, color3);//反転してくれる
						isProcessed = true;
						}   
                        else{
                            Color color1 = input1.getColor(width-j-120,i);
                            output.setColor(width-j-a,i,color1);
                            isProcessed = true;
						}
						if(isProcessed = false){
							Color color2 = input2.getColor(j, i);
							output.setColor(width-j-a,i,color2);//左上に出てるやつ
							isProcessed = true;
						}
						// 代入が適用されると変数isProcessedにtrueが代入、
						//つまりinput2との処理が省略され、input2の画素値は代入されない
                        
                    }					
				}

                // 画素値がimage2の内部にあるか判定、かつinput1の画素値が代入されていなければ、
				//inpput2をoutputに代入3
				if(i < height2 && j < width2) {
					if(isProcessed == false) {   
						Color color2 = input2.getColor(j, i);
						 output.setColor(j, i, color2);//背景の出力をしている
					}
                }	
			
			}
		}
		return output;

	}

}
