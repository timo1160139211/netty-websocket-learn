/*
 * file_name: NettyConfig.java
 *
 * Copyright GaoYisheng Corporation 2017
 *
 * License：
 * date： 2018年3月6日 下午12:59:03
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

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 存储整个工程的全局配置.
 * @author gaoyisheng
 *
 */
public class NettyConfig {
	
	/**
	 *存储每一个客户端接入进来时的channel. 
	 */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
