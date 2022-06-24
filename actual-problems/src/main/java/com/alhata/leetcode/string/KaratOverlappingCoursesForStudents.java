package com.alhata.leetcode.string;

import com.alhata.leetcode.common.CommonUtil;

import java.util.*;

/**
 * You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.
 * Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.
 *
 * Sample Input:
 *
 * student_course_pairs_1 = [
 *   ["58", "Software Design"],
 *   ["58", "Linear Algebra"],
 *   ["94", "Art History"],
 *   ["94", "Operating Systems"],
 *   ["17", "Software Design"],
 *   ["58", "Mechanics"],
 *   ["58", "Economics"],
 *   ["17", "Linear Algebra"],
 *   ["17", "Political Science"],
 *   ["94", "Economics"],
 *   ["25", "Economics"],
 * ]
 *
 * Sample Output (pseudocode, in any order):
 *
 * find_pairs(student_course_pairs_1) =>
 * {
 *   [58, 17]: ["Software Design", "Linear Algebra"]
 *   [58, 94]: ["Economics"]
 *   [58, 25]: ["Economics"]
 *   [94, 25]: ["Economics"]
 *   [17, 94]: []
 *   [17, 25]: []
 * }
 *
 * Additional test cases:
 *
 * Sample Input:
 *
 * student_course_pairs_2 = [
 *   ["42", "Software Design"],
 *   ["0", "Advanced Mechanics"],
 *   ["9", "Art History"],
 * ]
 *
 * Sample output:
 *
 * find_pairs(student_course_pairs_2) =>
 * {
 *   [0, 42]: []
 *   [0, 9]: []
 *   [9, 42]: []
 * }
 *
 * Space Complexity: O(n*n)
 * Time Complexity: O(n*n)
 */
public class KaratOverlappingCoursesForStudents {
    public static void main(String[] args) {
        String[][] studentCourse = {
                {"58", "Software Design"},
                {"58", "Linear Algebra"},
                {"94", "Art History"},
                {"94", "Operating Systems"},
                {"17", "Software Design"},
                {"58", "Mechanics"},
                {"58", "Economics"},
                {"17", "Linear Algebra"},
                {"17", "Political Science"},
                {"94", "Economics"},
                {"25", "Economics"},
        };

        Map<String, List<String>> map = findOverlappingCoursesOfStudents(studentCourse);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue().toArray()));
        }
    }

    private static Map<String, List<String>> findOverlappingCoursesOfStudents(String[][] studentCourses) {
        Map<String, List<String>> resultMap = new HashMap<>();
        Map<String, List<String>> studentCourseMap = new HashMap<>();
        Set<String> students = new HashSet<>();
        for(String[] studentCourse : studentCourses) {
            students.add(studentCourse[0]);
            if (studentCourseMap.get(studentCourse[0]) == null) {
                List<String> courseList = new ArrayList<>();
                courseList.add(studentCourse[1]);
                studentCourseMap.put(studentCourse[0], courseList);
            }else {
                studentCourseMap.get(studentCourse[0]).add(studentCourse[1]);
            }
        }

//        CommonUtil.printMap(studentCourseMap);
        List<String> studentList = new ArrayList<>(students);
        for(int i=0;i<studentList.size();i++) {
            for(int j=i+1;j<studentList.size();j++) {
                resultMap.put(studentList.get(i) +" , "+ studentList.get(j), intersect(studentCourseMap.get(studentList.get(i)), studentCourseMap.get(studentList.get(j))));
            }
        }

        return resultMap;
    }

    private static List<String> intersect(List<String> courseList1, List<String> courseList2) {
        List<String> intersections = new ArrayList<>();

        if(courseList1 == null || courseList2 == null) return intersections;

        Set<String> set = new HashSet<>(courseList1);
        for (String course : courseList2) {
            if(set.contains(course)){
                intersections.add(course);
            }
        }

        return intersections;
    }
}

