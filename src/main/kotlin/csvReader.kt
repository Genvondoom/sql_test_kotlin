import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.*


data class students(val matricNo: String, val name: String)

class CsvAdapter() {
    fun reader(fileDirectory: String): MutableList<students> {
        val result = mutableListOf<students>()
        //val fileName = "/home/vdprime/Documents/Clinitians.csv"
        val lines = File(fileDirectory).readLines().toMutableList()// converts list toa mutable to be able to edit it
        lines.removeAt(0)// to remove header
        lines.forEach { line ->
            val temp = line.split(",").toList() // convert lines from csv to list by spliting it with comma
            result.add(students(temp[0], temp[1]))
        }
        return result
    }

    fun checkdir(fileName: String, directory: String) {
        var count = 0
        val fileCheck = if (File("${directory}$fileName").exists()) {
            val TempSpliter = fileName.split(".").toMutableList()
            var tempJoiner:String? =null
            TempSpliter[0] = "${TempSpliter[0]}${count + 1}"
            tempJoiner = TempSpliter.joinToString(".")
            println(tempJoiner)
        } else println("ok")
    }

    fun demoCsvFile(location: String) {
        val FILENAME = "${location}students.csv"
        val HEADER = "matric number, students name"
        val fileWriter: FileWriter = FileWriter(FILENAME, false)
        fileWriter.append(HEADER.toUpperCase())
        fileWriter.flush()
        fileWriter.close()
    }
}


fun main() {
    val csv_adapter = CsvAdapter()

    //print(csv_adapter.reader("/home/vdprime/Documents/test.csv"))
    csv_adapter.demoCsvFile("/home/vdprime/Documents/")
    csv_adapter.checkdir(directory = "/home/vdprime/Documents/", fileName = "students1.csv")


}
