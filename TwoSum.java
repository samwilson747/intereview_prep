import java.util.Map;
import java.util.HashMap;

class TwoSum {
   /*
     given array of integers and specified target,
     return array of the index of 2 values that add_argument
     up to the target value. Empty if such values do not exist

   ex:
     nums = [2, 7, 11, 15]  target = 9

     return [0,1] // nums[0] + nums[1] = target
   */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> seen_nums = new HashMap<Integer,Integer>(); //contains index, nums[index]
        for(int i = 0; i < nums.length; i++) {
            int curr_target = target - nums[i];
            if(seen_nums.containsKey(curr_target)){
                return new int[]{seen_nums.get(curr_target), i};
            }
            seen_nums.put(nums[i], i);
        }
        //values not found, return empty
        return new int[2];
    }
/*
    public static void main(String[] args) {
      //given case
      int[] returned = twoSum(new int[] {2,7,11,15}, 9);
      for(int i = 0; i < returned.length; i++)
         System.out.print(returned[i]+" ");
   }
*/
}
