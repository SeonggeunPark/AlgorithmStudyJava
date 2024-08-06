import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[6][2];

        for (int i = 0; i < 6; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        int max=0, maxI=0;
        
        for (int i=0; i<6; i++) {
            if (max < arr[i][1]) {
                max = arr[i][1];
                maxI = i;
            }
        }
        int maxI_l = maxI == 0 ? 5 : maxI-1;
        int maxI_r = maxI == 5 ? 0 : maxI+1;
        int maxI_next = arr[maxI_l][1] > arr[maxI_r][1] ? maxI_l : maxI_r ;

//        int maxI_l = maxI == 0 ? 5 : maxI-1;
//        int maxI_r = maxI == 5 ? 0 : maxI+1;
//        int maxI_next = arr[maxI_l][1] > arr[maxI_r][1] ? maxI_l : maxI_r ;
        int targetI1, targetI2;
        if (maxI-maxI_next == 1 || maxI-maxI_next == -5) {
        	targetI1 = maxI_next - 2 >= 0 ? maxI_next - 2 : 6 + maxI_next - 2;
        	targetI2 = maxI + 2 < 6 ? maxI + 2 : maxI + 2 - 6;
        } else {
        	targetI1 = maxI - 2 >= 0 ? maxI - 2 : 6 + maxI - 2;
        	targetI2 = maxI_next + 2 < 6 ? maxI_next + 2 : maxI_next + 2 - 6;
        }
        int ans = (arr[maxI][1] * arr[maxI_next][1] - arr[targetI1][1] * arr[targetI2][1]) * n;
//        System.out.println(maxI + " " + maxI_next + " " + targetI1 + " " + targetI2);
        // 가로 세로 최대값 가진 방향 찾기
//        if (arr[0][0] <= 2) {
//            maxR = 0;
//            maxC = 1;
//        } else {
//            maxR = 1;
//            maxC = 0;
//        }
//        
//        for (int i = 2; i < 6; i++) {
//            int dir = arr[i][0];
////            System.out.println("dir : " + dir);
//            if (arr[i][0] <= 2) {
//                maxR = arr[maxR][1] < arr[i][1] ? i : maxR;
//            } else {
//                maxC = arr[maxC][1] < arr[i][1] ? i : maxC;
//            }
//        }
//        System.out.println(maxR + ", " + maxC);

        // 가로최대 다음 가로가 빈 가로 길이, 세로최대 전 세로가 빈 세로

        System.out.println(ans);

    }
}