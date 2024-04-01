/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class Solution {
    private val employeesInfoMap = hashMapOf<Int, Pair<Int, List<Int>>>()
    private val visited = PriorityQueue<Int>()

    fun getImportance(employees: List<Employee?>, id: Int): Int {
        employees.forEach {
            it?.let { employee ->
                employeesInfoMap[employee.id] = Pair(employee.importance, employee.subordinates)
            }
        }

        // id -> importance, {id1,id2,...}

        val requiredEmployee = employeesInfoMap[id]!!
        var employeeImportance = requiredEmployee.first
        requiredEmployee.second.forEach {
            visited.offer(it)
        }

        while (visited.isNotEmpty()) {
            val head = visited.poll()!!
            val employee = employeesInfoMap[head]!!
            employeeImportance += employee.first
            employee.second.forEach {
                visited.offer(it)
            }
        }
        return employeeImportance
    }
}