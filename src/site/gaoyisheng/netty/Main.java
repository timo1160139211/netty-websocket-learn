/*
 * file_name: Main.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2018年3月6日 下午4:21:12
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

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序入口.
 * @author gaoyisheng
 *
 */
public class Main {
	
	private static final int PORT = 8080;
	
	public static void main(String[] arg0) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new MyWebSocketChannelHandler());
			System.out.println("服务端开启等待客户端连接...");
			b.bind(PORT).sync().channel();
			Channel ch = b.bind(PORT).sync().channel();
			ch.closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
