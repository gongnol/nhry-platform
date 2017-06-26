package com.nhry.rest.basic;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TSysMessage;
import com.nhry.data.basic.domain.TVipCustInfo;
import com.nhry.model.basic.MessageModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.TSysMessageService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/mess")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/mess", description = "系统信息维护")
public class MessageResource extends BaseResource {
 @Autowired
 private TSysMessageService messService;
 
	@POST
	@Path("/{messageNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{messageNo}", response = TSysMessage.class, notes = "根据消息编号查看具体的系统信息")
	public Response findTSysmessageByNo(@ApiParam(required = true, name = "messageNo", value = "消息编号") @PathParam("messageNo") String messageNo) {
		return convertToRespModel(MessageCode.NORMAL, null,messService.findTSysmessageByNo(messageNo));
	}
   
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/search", response = TSysMessage.class, notes = "根据消息编号查看具体的系统信息")
	public Response searchMessage(@ApiParam(required = true, name = "mess", value = "消息对象") MessageModel mess) {
		return convertToRespModel(MessageCode.NORMAL, null,messService.searchMessages(mess));
	}
	
	@POST
	@Path("/close/{messageNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/close/{messageNo}", response = TSysMessage.class, notes = "关闭系统消息(变成已读)")
	public Response closeMessage(@ApiParam(required = true, name = "messageNo", value = "消息编号") @PathParam("messageNo") String messageNo) {
		return convertToRespModel(MessageCode.NORMAL, null,messService.closeMessage(messageNo));
	}
 
}
