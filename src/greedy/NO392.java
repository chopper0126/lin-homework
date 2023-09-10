package greedy;

//392. 判断子序列
public class NO392 {
   //
    public boolean isSubsequence(String s,String t){
        int index = -1;
        for (char c : s.toCharArray()){//转成char类型
             index = t.indexOf(c, index + 1);
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}
