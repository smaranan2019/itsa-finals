package itsa.patterns.sol;

import java.util.*;

class ApproverHandler {
	private int limit = 0;
	private String id = "";
	private ApproverHandler nextInChain;

	public ApproverHandler(String id, int limit) {
		this.limit = limit;
		this.id = id;
	}

    public void add(ApproverHandler next) {
        if (nextInChain == null) {
            nextInChain = next;
        } else {
            nextInChain.add(next);
        }
    }

    public String execute(int value) {
        if (value > limit) {
            return id + nextInChain.execute(value);
        } else {
			return id;
        }
    }
}

public class CORExample {
    public static void main(String[] args) {
        ApproverHandler rootChain = new ApproverHandler("1", 500);
        rootChain.add(new ApproverHandler("2", 1000));
        rootChain.add(new ApproverHandler("3", 1500));
        rootChain.add(new ApproverHandler("4", 1000000));

		int[] requests = {500, 1000, 1500, 5000};
		String ans = "";
		for (int i=0; i < requests.length; i++) {
            ans += rootChain.execute(requests[i]);
        }
        System.out.println(ans);
		// In COR, the sequence should be 1121231234
		assert ans.equals("1121231234") : "Sequence does not matched";
    }

}
