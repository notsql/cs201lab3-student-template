public class Q1Test {

    public static void main(String[] args) {
        String result, traversal1, traversal2, traversal3;

        traversal1 = "1-2";
        traversal2 = "2-1-3";
        traversal3 = "1-3-2";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Invalid traversals");
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "1-2-3";
        traversal2 = "2-1-3";
        traversal3 = "1-3-2";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println(
            "Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder"
        );
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "1-2-3";
        traversal2 = "3-2-1";
        traversal3 = "2-3-1";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println("Expected Result : Invalid traversals");
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "3-1-2-5-4";
        traversal2 = "2-1-4-5-3";
        traversal3 = "1-2-3-4-5";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println(
            "Expected Result : Traversal 1 - Preorder, Traversal 2 - Postorder, Traversal 3 - Inorder"
        );
        System.out.println("  Actual Result : " + result);
        System.out.println();

        traversal1 = "10-20-30-40-50";
        traversal2 = "20-10-30-40-50";
        traversal3 = "10-50-40-30-20";
        result = verify(traversal1, traversal2, traversal3);
        System.out.println("Traversal 1 : " + traversal1);
        System.out.println("Traversal 2 : " + traversal2);
        System.out.println("Traversal 3 : " + traversal3);
        System.out.println(
            "Expected Result : Traversal 1 - Inorder, Traversal 2 - Preorder, Traversal 3 - Postorder"
        );
        System.out.println("  Actual Result : " + result);
        System.out.println();
    }

    static boolean firstEqualsLast(String[] split1, String[] split2) {
        return split1[0].equals(split2[split2.length - 1]);
    }

    static String isMiddle(String[] split1, String[] split2, String result) {
        if (firstEqualsLast(split1, split2)) {
            return "Invalid traversals";
        }
        return result;
    }

    // write your codes here
    public static String verify(
        String traversal1,
        String traversal2,
        String traversal3
    ) {
        String[] split1 = traversal1.split("-");
        String[] split2 = traversal2.split("-");
        String[] split3 = traversal3.split("-");

        if (
            split1.length != split2.length ||
            split2.length != split3.length ||
            split1.length != split3.length
        ) {
            return "Invalid traversals";
        }

        String format = "Traversal 1 - %s, Traversal 2 - %s, Traversal 3 - %s";

        if (firstEqualsLast(split1, split2)) {
            return isMiddle(
                split2,
                split1,
                String.format(format, "Preorder", "Postorder", "Inorder")
            );
        } else if (firstEqualsLast(split1, split3)) {
            return isMiddle(
                split3,
                split1,
                String.format(format, "Preorder", "Inorder", "Postorder")
            );
        } else if (firstEqualsLast(split2, split1)) {
            return isMiddle(
                split1,
                split2,
                String.format(format, "Postorder", "Preorder", "Inorder")
            );
        } else if (firstEqualsLast(split2, split3)) {
            return isMiddle(
                split3,
                split2,
                String.format(format, "Inorder", "Preorder", "Postorder")
            );
        } else if (firstEqualsLast(split3, split1)) {
            return isMiddle(
                split1,
                split3,
                String.format(format, "Postorder", "Inorder", "Preorder")
            );
        } else if (firstEqualsLast(split3, split2)) {
            return isMiddle(
                split2,
                split3,
                String.format(format, "Postorder", "Preorder", "Inorder")
            );
        }

        return "Invalid traversals";
    }
}
