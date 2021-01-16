import java.util.*;
public class MicsAndJury {
    //We have to divide the array of m elements into n elements such that, the maximum element is minimized.

    public static int maxTeamSize(int N, int M, int[] teams) {
        int low = 1, high = Integer.MAX_VALUE;
        int ans = 0;
        while(low <= high) {
            int mid = low  + (high /2 - low / 2); 
            int newTeams = 0;
            for(int i = 0; i < M; i++) {
                if(teams[i] % mid != 0) {
                    newTeams += teams[i] / mid + 1;
                }
                else {
                    newTeams += teams[i] / mid;
                }
            }
            if(newTeams > N) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] teams = new int[M];
        for(int i = 0; i < M; i++) {
            teams[i] = sc.nextInt();    //consits of number of people in each of M teams
        }
        System.out.println(maxTeamSize(N, M, teams));
    }
}
