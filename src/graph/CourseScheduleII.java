package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/
public class CourseScheduleII {
	public static void main(String args[]) {
		int numCourses = 2;
		int prerequisites[][] = { { 1, 0 } };
		CourseScheduleII obj = new CourseScheduleII();
		for (int course : obj.findOrder(numCourses, prerequisites)) {
			System.out.print(course + " ");
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		HashMap<Integer, List<Integer>> preReqToCourses = new HashMap<>();
		List<Integer> preReqCountForCourses = new ArrayList<>();
		for (int i=0;i<numCourses;i++) {
			preReqCountForCourses.add(0);
		}
		
		System.out.println(preReqCountForCourses.size());
		setUp(numCourses, prerequisites, preReqToCourses, preReqCountForCourses);
		
		Queue<Integer> noPRcourses = new LinkedList<>();
		addCoursesToQueue(preReqCountForCourses,noPRcourses);
		
		ArrayList<Integer> result = new ArrayList<>();
		
		int totalElementsInQueue=0;
		while (!noPRcourses.isEmpty()) {
			totalElementsInQueue++;
			int noPRCourse = noPRcourses.poll();
			result.add(noPRCourse);
			
			for (int dependentCourse:preReqToCourses.get(noPRCourse)) {
				int dependentCoursePrereqCount = preReqCountForCourses.get(dependentCourse);
				preReqCountForCourses.set(dependentCourse,dependentCoursePrereqCount-1 );
				if (dependentCoursePrereqCount-1 == 0) 
					noPRcourses.add(dependentCoursePrereqCount);
			}
		}
		if (totalElementsInQueue==numCourses)
			return result.stream().mapToInt(i->i).toArray();
		else
			return null;
	}

	private void addCoursesToQueue(List<Integer> preReqCountForCourses, Queue<Integer> noPRcourses) {
		//add all courses with preReqCountForCourses=0 to queue, no dependency
		for (int course=0;course<preReqCountForCourses.size();course++) {
			if (preReqCountForCourses.get(course)==0) {
				noPRcourses.offer(course);
			}
		}
		
	}

	public void setUp(int numCourses, int[][] prerequisites, HashMap<Integer, List<Integer>> preReqToCourses,
			List<Integer> preReqCountForCourses) {
		for (int pair[] : prerequisites) {
			int course = pair[0];
			int preReq = pair[1];
			// increment indegree
			preReqCountForCourses.set(course, preReqCountForCourses.get(course) + 1);
			// prereq to course
			if (!preReqToCourses.containsKey(preReq))
				preReqToCourses.put(preReq, new ArrayList<>());
			preReqToCourses.get(preReq).add(course);
		}
	}

}
//indegree -> how many nodes depend on this node