import com.google.protobuf.ByteString
import com.rustyrazorblade.awfuldb.server.DB
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

internal class DBTest {
    @Test
    fun put() {
        var db = DB()

        var key = "test"
        var value = "{\"data\":\"value\"}"

        db.put(key, value)

        var key2 = "test"
        val tmp = db.get(key2).get()

        assertEquals(value, tmp)

    }

}