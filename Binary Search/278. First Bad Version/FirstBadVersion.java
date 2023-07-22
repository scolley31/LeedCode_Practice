package org.example;


/*
 * Time Complexity O(log(n))
 * Space Complexity O(1)
 * */

public class FirstBadVersion extends VersionControl {
    public static int firstBadVersion(int n) {
        int firstVersion = 1;
        int lastVersion = n;

        while (firstVersion < lastVersion) {
            int badVersion = firstVersion + ((lastVersion - firstVersion) / 2);
            if (isBadVersion(badVersion)) {
                lastVersion = badVersion;
            } else {
                firstVersion = badVersion + 1;
            }
        }
        return lastVersion;
    }
}
