class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] v = new boolean[9];
        boolean[] h = new boolean[9];
        boolean[] s = new boolean[9];

        for (int i = 0; i < 7; i = i + 3) {
            for (int j = 0; j < 7; j = j + 3) {
                for (int x = 0; x < 9; x++) {
                    s[x] = true;
                }
                for (int n = 0; n < 3; n++) {
                    for (int m = 0; m < 3; m++) {
                        char cs = board[i+n][j+m];
                        if (cs == '.') {
                            continue;
                        } else {
                            int x = (int) (cs - '0') - 1;
                            boolean isTrue = s[x];
                            if (!isTrue) {
                                return false;
                            } else {
                                s[x] = false;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int n = 0; n < 9; n++) {
                v[n] = true;
                h[n] = true;
            }
            for (int j = 0; j < 9; j++) {
                char cv = board[i][j];
                char ch = board[j][i];
                if (cv == '.') {
                } else {
                    int x = (int) (cv - '0') - 1;
                    boolean isTrue = v[x];
                    if (!isTrue) {
                        return false;
                    } else {
                        v[x] = false;
                    }
                }

                if (ch == '.') {
                } else {
                    int x = (int) (ch - '0') - 1;
                    boolean isTrue = h[x];
                    if (!isTrue) {
                        return false;
                    } else {
                        h[x] = false;
                    }
                }
            }
        }        
        return true;
    }
}
