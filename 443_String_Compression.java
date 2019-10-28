class Solution {
    public int compress(char[] arr) {
    //[a,a,a,b,b,a]
        if (arr.length <= 1) {
          return arr.length;
        }
        int write = 1;
        int count = 0;
        char current = arr[0];

        for (int i = 0; i < arr.length; i++) {
          if (arr[i] != current) {
            if (count > 1) {
              char[] countArr = (count+"").toCharArray();
              int arrLen = countArr.length;
              for (int j = 0; j < arrLen; j++) {
                arr[write] = countArr[j];
                write++;
              }
            }
            arr[write] = arr[i];
            write++;
            count = 1;
            current = arr[i];
          } else {
            count++;
          }
        }
        if (count > 1) {
          char[] countArr = (count+"").toCharArray();
          int arrLen = countArr.length;
          for (int j = 0; j < arrLen; j++) {
            arr[write] = countArr[j];
            write++;
          }
        }
        return write;
    }
}