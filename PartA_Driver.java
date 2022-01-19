package A3;


/**
 * Write a description of class PartA_Driver here.
 *
 * @author (Harnoor Sidhu 3111085)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class PartA_Driver {
    public static void main(String[] args) {
        LinkedBinaryTree<String> decisionTree = new LinkedBinaryTree<>();
        
        decisionTree.addRoot("Going to Sleep? (Yes/No)");
        
        Position<String> p = decisionTree.root();
        
        decisionTree.addLeft(p, "Weather bad? (Yes/No)")
        ;
        decisionTree.addRight(p, "Watch Netflix.");
        
        p = decisionTree.left(p);
        
        decisionTree.addLeft(p, "Play with People Hearts");
        
        decisionTree.addRight(p, "Are you rich?(Yes/No)");
        
        p = decisionTree.right(p);
        
        decisionTree.addLeft(p, "Go shopping");
        
        decisionTree.addRight(p, "go to grocery.");
        
        p = decisionTree.root();
        
        System.out.println(p.getElement());
        
        Scanner kb = new Scanner(System.in);
        while(!decisionTree.isExternal(p)){            
            String u = kb.next().trim();
            if(u.equalsIgnoreCase("yes")){
                p = decisionTree.left(p);
                System.out.println(p.getElement());
            }if(u.equalsIgnoreCase("no")){
                p = decisionTree.right(p);
                System.out.println(p.getElement());
            }
        }
        System.out.println("********************\nEnd of Program.");
        System.out.println(decisionTree);
    }
}