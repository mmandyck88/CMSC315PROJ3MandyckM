/** Purpose of Program: Binary Tree Program checker. Implements a second constructor to create a tree from a string
 * Revise preorder method. Implements isMaxHeap, isBinarySearchTree, inorderList, and Main method.
* Author: Melissa Mandyck Instructor: Duane Jarc  *Date: 06/24/2025 
*Modifications: none      
 */
// CMSC315PROJ3MandyckM Java File

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Binary Tree Program!\nPlease insert integers with a space in between (ex: 1 2 3 4 5).\n");

        while (true) {
            try {
                System.out.print("Enter a binary tree: ");
                String treeString = input.nextLine();

                CompleteBinaryTree tree = new CompleteBinaryTree(treeString);
                tree.preorder();

                System.out.println("Is a max-heap: " + tree.isMaxHeap());
                System.out.println("Is a binary search tree: " + tree.isBinarySearchTree());
                System.out.println("Inorder List: " + tree.inorderList());

            } catch (InvalidTreeException e) {
                System.out.println(e.getMessage());
            }

            // Prompt Asks User if Wants to Continue
            System.out.print("Would you like to check another binary tree? (type yes/no): ");
            String response = input.nextLine().trim().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                System.out.println("Thank you for using the Binary Tree Program. Closing the program...");
                break;
            }
        }

        input.close();
    }
}


//ends CMSC315PROJ3MandyckM Java File
