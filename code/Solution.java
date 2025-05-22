package code;

/**
 * @author :  sardor.matniyazov
 * @mailto :  sardorbekmatniyazov03@gmail.com
 * @created : 21 май 2025
 **/
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // first if two string is same length
        int multiply, inHead = 0, len1 = num1.length(), len2 = num2.length();

        String multiplication = "0";
        for (int i = 0; i < len1; i++) {
            int cur = num1.charAt(len1 - i - 1) - '0';
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < num2.length(); j++) {
                multiply = cur * (num2.charAt(len2 - j - 1) - '0');

                if ((multiply + inHead) / 10 > 0) {
                    result.append((multiply + inHead) % 10);
                    inHead = (multiply + inHead) / 10;
                } else {
                    result.append(multiply + inHead);
                    inHead = 0;
                }
            }
            if (inHead > 0) {
                result.append(inHead);
            }

            inHead = 0;

            multiplication = add(multiplication, addZeroAfter(result.reverse().toString(), i));
        }

        return multiplication;

    }

    private String add(String num1, String num2) {
        // make two string is same length
        num1 = addZeroBeforeByLength(num1, num2.length());
        num2 = addZeroBeforeByLength(num2, num1.length());

        int addition, inHead = 0, len = num1.length();
        StringBuilder result = new StringBuilder();

        for (int i = len - 1; i > -1; i--) {
            addition = (num1.charAt(i) - '0') + (num2.charAt(i) - '0');

            if ((addition + inHead) / 10 > 0) {
                result.append((addition + inHead) % 10);
                inHead = (addition + inHead) / 10;
            } else {
                result.append(addition + inHead);
                inHead = 0;
            }
        }
        if (inHead > 0) {
            result.append(inHead);
        }
        return result.reverse().toString();
    }

    private String addZeroBeforeByLength(String num, int length) {
        return "0".repeat(Math.max(0, length - num.length())) + num;
    }

    private String addZeroAfter(String num, int n) {
        return num + "0".repeat(Math.max(0, n));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "9", num2 = "789";
        // 26556574961086181862161214510762702964339488343
        // 11295943524218632378386856562147743

        String add = solution.add(num1, num2);
        String multiply = solution.multiply(num1, num2);
        System.out.println(add);
        System.out.println(multiply);
    }
}
