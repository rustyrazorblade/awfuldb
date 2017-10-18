import com.google.protobuf.ByteString
import com.rustyrazorblade.awfuldb.server.DB
import org.junit.jupiter.api.Assertions.*

internal class DBTest {
    @org.junit.jupiter.api.Test
    fun put() {
        var db = DB()

        var key = ByteString.copyFromUtf8("key")
        var value = ByteString.copyFromUtf8("value")

        db.put(key, value)

        var key2 = ByteString.copyFromUtf8("key")
        val tmp = db.get(key2)

        assertEquals(value, tmp)

    }

    @org.junit.jupiter.api.Test
    fun testByteString() {
        var k1 = ByteString.copyFromUtf8("test")
        var k2 = ByteString.copyFromUtf8("test")
        assertEquals(k1, k2)
    }

}