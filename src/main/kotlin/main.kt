import java.sql.DriverManager

// the model class
data class User(val matric: String, val email: String, val password: String)

fun main() {

    val jdbcUrl = "jdbc:mysql://localhost:3306/ovs"

    // get the connection
    val connection = DriverManager
        .getConnection(jdbcUrl, "ovs", "Vondoom1&2")
    val query = connection.prepareStatement("Select * from users")
    val result = query.executeQuery()
    val final = mutableListOf<User>()
    while (result.next()) {

        val matric = result.getString("matricNo")
        val email = result.getString("email")
        val password = result.getString("password")
        if (matric != "") {
            final.add(User(matric, email, password))

        }


    }
    println(final[0])

}
