import java.util.Scanner;

public class q107 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String line = sc.nextLine();
        String[] tmp = line.split(" ");
        int n = Integer.parseInt(tmp[0]);//n種類のテスト
        int l = Integer.parseInt(tmp[1]);//L人で勝負

        int[][] scores = new int[l][n];//行列の箱

        
        int[] wincount = new int[l];//L人の中で一位を取った回数の配列

        int winner = -1;//最多勝は誰だ
        int winnerscount = -1;//最多勝生徒の勝ち数はいくつ

        for (int j = 0; j < l; j++){
            String lineA = sc.nextLine();
            String[] tmpA = lineA.split(" "); 
            for (int i = 0; i < n; i++){
                scores[j][i] = Integer.parseInt(tmpA[i]);
            }
        }

        for (int i = 0; i < n; i++){//1種類目からn種類目まで繰り返す
            int maxscorei = -1;//i種類目のテストの最高点(初期値)
            int topstudent = -1;//最高点をとった学生番号

            for (int j = 0; j < l; j++){//1人目からL人目まで繰り返す 
                if (scores [j][i] > maxscorei){
                    maxscorei = scores[j][i];
                    topstudent = j;
                }
             }
            wincount[topstudent]++;
            }
        for (int k = 0; k < l; k++){//L人の一位の回数を勝負
            if (wincount[k] > winnerscount){
                winner = k + 1;
                winnerscount = wincount[k];
            }
        }
        System.out.println(winner + " " +winnerscount);
    }
}
