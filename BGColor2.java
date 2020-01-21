
import java.awt.Color;


public class BGColor2 {

	public static MyImage execute(MyImage input) {

		MyImage output = new MyImage(input.width, input.height);
        
		for(int i = 0; i < input.height; i++) {
			for(int j = 0; j < input.width; j++) {
				
				Color color1 = input.getColor(j, i);
            
                int r = color1.getRed();
                int g = color1.getGreen();
                int b = color1.getBlue();
                int r1 = 0, g1 = 0, b1 = 0;
                //int b1 = (int)(255*Math.pow((double)b/255, 1/rb));
                if(r == 255){
                    if(g >= b){//②のサーモンピンク
                        r1 = 255;
                        g1 = (g/255)*122 + 127;
                        b1 = (b/255)*61 + 191;
                    }
                    else{//①のオレンジ
                        r1 = 255;
                        g1 = (g/255)*122 + 127;
                        b1 = (b/255)*122 + 127;
                    }
                }
                else if(g > r && g >= b){//⑥の水色へ
                    r1 = (r/255)*122 + 127;
                    g1 = (g/255)*61 + 191;
                    b1 = 255;
                }
                else if(b > r && b > g){
                    if(r > g){//④の紫
                        r1 = (r/255)*61 + 191;
                        g1 = (g/255)*122 + 127;
                        b1 = 255;
                    }
                    else{//⑤の青
                        r1 = (r/255)*122 + 127;
                        g1 = (g/255)*122 + 127;
                        b1 = 255;
                    }
                }
                else{//③のショッキングピンク
                    r1 = 255;
                    g1 = (g/255)*122 + 127;
                    b1 = 255;
                }
				Color color2 = new Color(r1, g1, b1);

				output.setColor(j, i, color2);
			}
		}
		
		return output;
	}

}

