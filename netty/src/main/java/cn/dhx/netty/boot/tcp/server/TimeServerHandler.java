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
package cn.dhx.netty.boot.tcp.server;

import cn.dhx.netty.boot.entity.AudioStream;
import cn.dhx.netty.boot.util.NetByteUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.ArrayUtils;


public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        System.out.println("The time server receive order : " + body);
//        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(
//                System.currentTimeMillis()).toString() : "BAD ORDER";
//        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.write(resp);

        System.out.println("--------");

        byte[] bytes3= (byte[]) msg;
        String body3 = new String(bytes3, "UTF-8");
        System.out.println(body3);

        AudioStream audioStream = new AudioStream();
        audioStream.setCmd("aa");
        audioStream.setCallid("38248268aw");
        audioStream.setCaller("18270779730");
        audioStream.setCallee("1002");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writeValueAsString(audioStream);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        int length = jsonStr.length();

        byte[] length4 = NetByteUtil.intToBytes(length);
        byte[] jsonStrBytes = jsonStr.getBytes();
        byte[] bytes2 = ArrayUtils.addAll(length4, jsonStrBytes);
        ByteBuf buffer = Unpooled.buffer(bytes2.length);
        buffer.writeBytes(bytes2);
        ctx.channel().writeAndFlush(buffer);

//        ByteBuf inMessage = (ByteBuf) msg;
//        byte[] bytes4 = new byte[4];
//        inMessage.readBytes(bytes4);
//        int length = NetByteUtil.bytesToInt(bytes4);
//        System.out.println(length);
//        int readable = inMessage.readableBytes();
//        byte[] bytes = new byte[length];
//        inMessage.readBytes(bytes);
//        String body = new String(bytes, "UTF-8");
//        System.out.println(body);
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
