package java8;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : dongfucai@meituan.com
 * @Creation Date : 2019年01月20日下午4:57
 * @Function : todo
 */
public class Exercise {


    static class StudentId {
        public Integer id;

        void setId(Integer id) {
            this.id = id;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            StudentId brandInfo = (StudentId) o;

            if (!id.equals(brandInfo.id)) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result;
            return result;
        }


    }
    public static void main(String args[]) {

        Set<StudentId> studentSet = Sets.newHashSet();
        StudentId studentId = new StudentId();
        studentId.setId(1);

        StudentId studentId1 = new StudentId();
        studentId1.setId(1);

        studentSet.add(studentId);
        studentSet.add(studentId1);

        System.out.println(studentSet.size());




        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result0 = getFilterOutput(lines, "mkyong");
        // output "spring", "node"
        for (String temp : result0) {
            System.out.println(temp);
        }

    /* The equivalent example in Java 8, using stream.filter() to
  filter a list, and collect() to convert a stream.
   */
        List<String> result1 = lines.stream()  // convert list to stream
                .filter(line -> !"mkyong".equals(line)) // filter the line which equals to "mkyong"
                .collect(Collectors.toList());  // collect the output and convert streams to a list

        result1.forEach(System.out::println); // output "spring", "node"
    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"mkyong".equals(line)) {
                result.add(line);
            }
        }
        return result;
    }

}
