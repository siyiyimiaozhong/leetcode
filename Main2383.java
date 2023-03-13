/**
 * @Author: Chengxin Zhang
 * @Description:
 * @Project: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Main2383.java
 * @CreateTime: 2023-03-13  09:29
 * @Version: 1.0
 */
public class Main2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                int x = energy[i] - initialEnergy + 1;
                res += x;
                initialEnergy += x;
            }
            if (initialExperience <= experience[i]) {
                int x = experience[i] - initialExperience + 1;
                res += x;
                initialExperience += x;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int initialEnergy = 5;
        int initialExperience = 3;
        int[] energy = new int[]{1, 4, 3, 2};
        int[] experience = new int[]{2, 6, 3, 1};

        Main2383 main2383 = new Main2383();
        System.out.println(main2383.minNumberOfHours(initialEnergy, initialExperience, energy, experience) == 8);
    }
}
