import java.util.ArrayList;
import java.util.List;

Time complexity: O(h) where h is the height of the tree
Space complexity: O(n) in the worst case, where n is the number of employees
class Main {
  public static void main(String[] args) {
    int[] boss = { 1, 3, 3, -1, -1, 4, 2, 8, 3 };
    System.out.println(lowestCommonBoss(boss, 1, 1));  // 1
		System.out.println(lowestCommonBoss(boss, 2, 0));  // 3
    System.out.println(lowestCommonBoss(boss, 6, 0));  // 3
    System.out.println(lowestCommonBoss(boss, 7, 1));  // 3
    System.out.println(lowestCommonBoss(boss, 4, 5));  // 4
    System.out.println(lowestCommonBoss(boss, 6, 5));  // -1
    System.out.println(lowestCommonBoss(boss, 4, 2));  // -1
    System.out.println(lowestCommonBoss(boss, 4, 3));  // -1
    System.out.println(lowestCommonBoss(boss, 4, -1));  // -1
    System.out.println(lowestCommonBoss(boss, 3, 7));  // 3
  }

	static int lowestCommonBoss(int[] boss, int e1, int e2) {

    int result = -100;

    //Edge cases
    if (e1==e2)  return e1;
    if ((e1==-1)||(e2==-1)) return -1;
    
    //Paths from employees to boss
    List<Integer> path1 = new ArrayList<>();
    path1.add(e1);
    List<Integer> path2 = new ArrayList<>();
    path2.add(e2);
    int boss1 = boss[e1];
    path1.add(boss1);

    while (boss1 != -1)
    {
      int temp = boss[boss1];
      path1.add(temp);
      boss1 = temp;
    }
    
    int boss2 = boss[e2];
    path2.add(boss2);

    while (boss2 != -1)
    {
      int temp = boss[boss2];
      path2.add(temp);
      boss2 = temp;
    }    

    if (path1.size()==path2.size())
    {
      for (int i=0; i < path1.size();i++)
      {
        if (path1.get(i)==path2.get(i))
        {
          result = path1.get(i);
          break;
        }
      }
    }
    else
    {
      int minLength = (path1.size()<path2.size()?path1.size():path2.size());
      
      int index1 = path1.size()-1;
      int index2 = path2.size()-1;

      for (int i=minLength-1;i>=0;i--)
      {
        if (path1.get(index1)==path2.get(index2))
        {
          result = path1.get(index1);
          index1--;
          index2--;
        }
      }
    }  

    return result;
	}
}
