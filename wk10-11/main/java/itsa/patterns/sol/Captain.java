package itsa.patterns.sol;

public class Captain
{
    private static Captain captain = new Captain();
    //We make the constructor private to prevent the use of "new"
    private Captain() {   }
    public static Captain getCaptain() {
        return captain;
    }
	
// We cannot extend Captain class.The constructor is private in this case.
    public static void main(String[] args) {
        System.out.println("***Singleton Pattern Demo***\n");
        System.out.println("Trying to make a captain for your team:");
        //Constructor is private.We cannot use "new" here.
        Captain captain1 = Captain.getCaptain();
        System.out.println("Trying to make another captain for your team:");
        Captain captain2 = Captain.getCaptain();
        if (captain1 == captain2)
        {
            System.out.println("captain1 and captain2 are same instance.");
        }
    }
}