package com.practice.javacode.recursion;

public class RecursionExamples {
    int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    int binarySearch(int[] arr, int l, int r, int x) {
        if (l > r) return -1;

        int mid = (l + r) / 2;

        if (arr[mid] == x) return mid;
        if (x < arr[mid]) return binarySearch(arr, l, mid - 1, x);
        return binarySearch(arr, mid + 1, r, x);
    }

    boolean isPalindrome(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindrome(s, start + 1, end - 1);
    }

    String reverse(String s) {
        if (s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }

    void print1ToN(int n) {
        if (n == 0) return;
        print1ToN(n - 1);
        System.out.println(n);
    }

    void printNTo1(int n) {
        if (n == 0) return;
        System.out.println(n);
        printNTo1(n - 1);
    }

    int sum(int n) {
        if (n == 0) return 0;
        return n + sum(n - 1);
    }

    int countDigits(int n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    int sumDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumDigits(n / 10);
    }

    int reverse(int n, int rev) {
        if (n == 0) return rev;
        return reverse(n / 10, rev * 10 + n % 10);
    }

    int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        hanoi(n - 1, aux, to, from);
    }

    int sumArray(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + sumArray(arr, i + 1);
    }

    int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        return Math.max(arr[index], findMax(arr, index + 1));
    }

    int findMin(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        return Math.min(arr[i], findMin(arr, i + 1));
    }

    int countOcc(int[] arr, int i, int target) {
        if (i == arr.length) return 0;
        return (arr[i] == target ? 1 : 0) + countOcc(arr, i + 1, target);
    }

    boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        return arr[i] <= arr[i + 1] && isSorted(arr, i + 1);
    }

    void subsets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        subsets(s, curr + s.charAt(i), i + 1); // include
        subsets(s, curr, i + 1);               // exclude
    }

    void permute(String s, String ans) {
        if (s.isEmpty()) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            permute(s.substring(0, i) + s.substring(i + 1), ans + s.charAt(i));
        }
    }

    void binary(int n) {
        if (n == 0) return;
        binary(n / 2);
        System.out.print(n % 2);
    }

    int climb(int n) {
        if (n <= 1) return 1;
        return climb(n - 1) + climb(n - 2);
    }

    boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q') return false;

        return true;
    }

    void solve(char[][] board, int row) {
        if (row == board.length) {
            for (char[] r : board) System.out.println(java.util.Arrays.toString(r));
            System.out.println();
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solve(board, row + 1);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    boolean solveMaze(int[][] maze, int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) return true;
        if (x >= maze.length || y >= maze[0].length || maze[x][y] == 0) return false;

        return solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1);
    }

    void generate(int open, int close, String s) {
        if (open == 0 && close == 0) {
            System.out.println(s);
            return;
        }
        if (open > 0) generate(open - 1, close, s + "(");
        if (close > open) generate(open, close - 1, s + ")");
    }

}
