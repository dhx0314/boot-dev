/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package cn.dhx.nettyvoice.tcpserver;

import cn.dhx.nettyvoice.entity.AudioStream;
import cn.dhx.nettyvoice.entity.AudioStreamResp;
import cn.dhx.nettyvoice.util.JsonUtil;
import cn.dhx.nettyvoice.util.NetByteUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;


@Slf4j
public class TimeServerHandler extends SimpleChannelInboundHandler<byte[]> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {

        String body = new String(msg, "UTF-8");
        log.info("channel Read {}", body);
        AudioStream audioStream = JsonUtil.toObject(body, AudioStream.class);

        String cmd = audioStream.getCmd();
        log.info("cmd [{}]",cmd);
        if (!"OpenAudioStream".equals(cmd)) {
            log.error("cmd [{}]",cmd);
            return;
        }

        AudioStreamResp audioStreamResp = new AudioStreamResp();
        audioStreamResp.setCallid(audioStream.getCallid());
        audioStreamResp.setResultNo(0);
        audioStreamResp.setResultDesc("test");
        audioStreamResp.setRespCmd("OpenAudioStreamResp");
        audioStreamResp.setMediaIP("172.16.2.214");
        audioStreamResp.setCallerPort(9001);
        audioStreamResp.setCalleePort(9002);

        String jsonStr = JsonUtil.toString(audioStreamResp);
        int length = jsonStr.length();

        byte[] length4 = NetByteUtil.intToBytes(length);
        byte[] jsonStrBytes = jsonStr.getBytes();
        byte[] bytes2 = ArrayUtils.addAll(length4, jsonStrBytes);
        ByteBuf buffer = Unpooled.buffer(bytes2.length);
        buffer.writeBytes(bytes2);
        ctx.channel().writeAndFlush(buffer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
