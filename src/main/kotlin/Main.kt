import io.netty.buffer.Unpooled
import software.amazon.awssdk.core.SdkSystemSetting
import software.amazon.awssdk.http.crt.AwsCrtSdkHttpService

fun main() {

    System.setProperty(SdkSystemSetting.ASYNC_HTTP_SERVICE_IMPL.property(), AwsCrtSdkHttpService::class.java.canonicalName)

    Unpooled.buffer().release()
    println("Test")
}
