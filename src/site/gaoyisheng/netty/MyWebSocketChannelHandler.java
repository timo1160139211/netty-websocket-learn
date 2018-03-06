/*
 * file_name: MyWebSocketChannelHandler.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2018年3月6日 下午4:15:40
 *       https://www.gaoyisheng.site
 *       https://github.com/timo1160139211
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package site.gaoyisheng.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 初始化连接时的各个组件.
 * @author gaoyisheng
 *
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel e) throws Exception {
		e.pipeline()
		 .addLast("http-codec",new HttpServerCodec())
		 .addLast("aggregator",new HttpObjectAggregator(65536))
		 .addLast("http-chunked",new ChunkedWriteHandler())
		 .addLast("handler",new MyWebSocketHandler());
	}

}
