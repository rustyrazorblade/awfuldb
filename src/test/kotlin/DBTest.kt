import com.google.protobuf.ByteString
import com.rustyrazorblade.awfuldb.server.DB
import org.junit.jupiter.api.Assertions.*

internal class DBTest {
    @org.junit.jupiter.api.Test
    fun put() {
        var db = DB()

        var key = "key".toByteArray()


        var value = "value".toByteArray()

        db.put(key, value)

        var key2 = "test".toByteArray()
        val tmp = db.get(key2)

        assertNotNull(tmp)
    }

    @org.junit.jupiter.api.Test
    fun testByteString() {
        var k1 = ByteString.copyFromUtf8("test")
        var k2 = ByteString.copyFromUtf8("test")
        assertEquals(k1, k2)
    }

}