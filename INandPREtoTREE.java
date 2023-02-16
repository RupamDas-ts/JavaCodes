import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int[] preOrder;
    int[] inOrder;

    public Pair(int[] preOrder, int[] inOrder) {
        this.preOrder = preOrder;
        this.inOrder = inOrder;
    }

}

public class INandPREtoTREE {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair takeInput() throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine().trim());

        int pre[] = new int[n];
        int in[] = new int[n];

        String[] preOrder = br.readLine().trim().split(" ");
        String[] inOrder = br.readLine().trim().split(" ");


        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(preOrder[i].trim());
            in[i] = Integer.parseInt(inOrder[i].trim());
        }

        return new Pair(pre, in);

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);

        while(!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNodes.poll();


            if (frontNode == null) {
                System.out.println();

                if (!pendingNodes.isEmpty()) {
                    pendingNodes.add(null);
                }

            } else {
                System.out.print(frontNode.data + " ");

                if (frontNode.left != null) {
                    pendingNodes.add(frontNode.left);
                }

                if (frontNode.right != null) {
                    pendingNodes.add(frontNode.right);
                }
            }

        }

    }
    public static void main(String[] args) throws NumberFormatException, IOException {

        Pair input = takeInput();

        int[] preOrder = input.preOrder;
        int[] inOrder = input.inOrder;

        BinaryTreeNode<Integer> root = INandPREtoTREESolution.buildTree(preOrder, inOrder);

        printLevelWise(root);

    }
}

class INandPREtoTREESolution {
    private static int getIndex(int[] arr, int x){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    private static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder,int preSI, int preEI,
                                                           int[] inOrder, int inSI, int inEI){
        if(preSI > preEI || inSI > inEI){
            return null;
        }
        int rootData = preOrder[preSI];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rootIndexInOrder = getIndex(inOrder,rootData);

        //For Left Sub-Tree
        int leftPreSI = preSI + 1;
        int leftPreEI = leftPreSI + (rootIndexInOrder - inSI) - 1;
        int leftInSI = inSI;
        int leftInEI = rootIndexInOrder - 1;

        //For Right Sub-Tree
        int rightPreSI = leftPreEI+1;
        int rightPreEI = preEI;
        int rightInSI = rootIndexInOrder + 1;
        int rightInEI = inEI;

        root.left = buildTreeHelper(preOrder,leftPreSI,leftPreEI,inOrder,leftInSI,leftInEI);
        root.right = buildTreeHelper(preOrder,rightPreSI,rightPreEI,inOrder,rightInSI,rightInEI);
        return root;
    }
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        //Your code goes here
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[0]);
//        if(preOrder.length == 1){
//            return root;
//        }
//        int rootIndex = getIndex(inOrder, root.data);
//        int numberOfNodesLeft = rootIndex;
//        int numberOfNodesRight = inOrder.length - rootIndex - 1;
//
//        root.left = buildTree(Arrays.copyOfRange(preOrder, 1, numberOfNodesLeft + 1),
//                Arrays.copyOfRange(inOrder, 0, rootIndex));
//        root.right = buildTree(Arrays.copyOfRange(preOrder, numberOfNodesLeft + 1, preOrder.length),
//                Arrays.copyOfRange(inOrder, rootIndex + 1, inOrder.length));
//        return root;
        return buildTreeHelper(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

}