package com.diguage.algo.leetcode;

import java.util.*;

public class _0690_EmployeeImportance {
  // tag::answer[]

  /**
   * @author D瓜哥 · https://www.diguage.com
   * @since 2026-05-17 20:07:23
   */
  public int getImportance(List<Employee> employees, int id) {
    Map<Integer, Employee> idMap = new HashMap<>();
    employees.forEach(e -> idMap.put(e.id, e));
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(id);
    int result = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Integer no = queue.poll();
        Employee employee = idMap.get(no);
        result += employee.importance;
        employee.subordinates.forEach(queue::offer);
      }
    }
    return result;
  }
  // end::answer[]
  private static class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
  }
}
