package com.seena.practise.ds.stack;

/**
 * Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
 *
 * In Unix-style file system context, a single period '.' signifies the current directory, a double period ".." denotes moving up one directory level, and multiple slashes such as "//" are interpreted as a single slash. In this problem, treat sequences of periods not covered by the previous rules (like "...") as valid names for files or directories.
 *
 * The simplified canonical path should adhere to the following rules:
 *
 * It must start with a single slash '/'.
 * Directories within the path should be separated by only one slash '/'.
 * It should not end with a slash '/', unless it's the root directory.
 * It should exclude any single or double periods used to denote current or parent directories.
 * Return the new path.
 */

import java.util.Stack;

/**
 * Approach
 * The problem can be solved using a stack to keep track of the directories in the path. We split the input path by slash '/', iterate over the directories, and perform the following operations:
 *
 * Ignore the current directory '.' and empty directories.
 * Go one level up for double period '..' by popping the top element from the stack if it is not empty.
 * For any other directory, push it to the stack.
 * Finally, we join the directories in the stack with slash '/' and add a slash at the beginning to form the simplified canonical path.
 * Complexity
 * Time complexity:
 * The time complexity of the algorithm is O(n), where n is the length of the input path. This is because we iterate over each directory in the path only once.
 *
 * Space complexity:
 * The space complexity of the algorithm is O(n) where n is the length of
 */
public class SimplyPath {
    public static void main(String[] args) {
        String input = "/a//b////c/d//././/..";
        SimplyPath simplyPath = new SimplyPath();
        System.out.println("Simplified Path == >" + simplyPath.simplifyPath(input));
    }

    private String simplifyPath(final String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals(".") || dir.isEmpty()) {  // ignore the current directory '.' and empty directories
                continue;
            } else if (dir.equals("..")) {// go one level up for double period '..'
                if (!stack.isEmpty()) { // if stack is not empty, pop the top element
                    stack.pop();
                }
            } else {
                stack.push(dir);// for any other directory, push it to the stack
            }
        }
        return "/"+String.join("/", stack); // join the directories in the stack with slash '/' and add a slash at the beginning
    }
}
