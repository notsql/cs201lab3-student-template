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

    // checks that pre[ps..ps+len), in[is..is+len), post[qs..qs+len)
    // describe the same binary tree
    static boolean matches(
        String[] pre, int ps,
        String[] in, int is,
        String[] post, int qs,
        int len
    ) {
        if (len == 0) {
            return true;
        }
        String root = pre[ps];
        if (!post[qs + len - 1].equals(root)) {
            return false;
        }
        int rootIdx = -1;
        for (int i = is; i < is + len; i++) {
            if (in[i].equals(root)) {
                rootIdx = i;
                break;
            }
        }
        if (rootIdx == -1) {
            return false;
        }
        int leftLen = rootIdx - is;
        int rightLen = len - 1 - leftLen;
        return (
            matches(pre, ps + 1, in, is, post, qs, leftLen) &&
            matches(pre, ps + 1 + leftLen, in, rootIdx + 1, post, qs + leftLen, rightLen)
        );
    }

    // inorder traversal of a binary search tree is in ascending order
    static boolean isAscending(String[] values) {
        for (int i = 1; i < values.length; i++) {
            if (Integer.parseInt(values[i - 1]) >= Integer.parseInt(values[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(String[] pre, String[] in, String[] post) {
        return isAscending(in) && matches(pre, 0, in, 0, post, 0, in.length);
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

        if (split1.length != split2.length || split2.length != split3.length) {
            return "Invalid traversals";
        }

        String format = "Traversal 1 - %s, Traversal 2 - %s, Traversal 3 - %s";

        if (isValid(split1, split2, split3)) {
            return String.format(format, "Preorder", "Inorder", "Postorder");
        } else if (isValid(split1, split3, split2)) {
            return String.format(format, "Preorder", "Postorder", "Inorder");
        } else if (isValid(split2, split1, split3)) {
            return String.format(format, "Inorder", "Preorder", "Postorder");
        } else if (isValid(split2, split3, split1)) {
            return String.format(format, "Postorder", "Preorder", "Inorder");
        } else if (isValid(split3, split1, split2)) {
            return String.format(format, "Inorder", "Postorder", "Preorder");
        } else if (isValid(split3, split2, split1)) {
            return String.format(format, "Postorder", "Inorder", "Preorder");
        }

        return "Invalid traversals";
    }
}
