package com.nhry.rest.order;

import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdBranch;
import com.nhry.data.order.domain.TPromotion;
import com.nhry.model.order.OrderCreateModel;
import com.nhry.model.order.OrderSearchModel;
import com.nhry.model.order.PromSearchModel;
import com.nhry.model.order.PromotionOrderModel;
import com.nhry.rest.BaseResource;
import com.nhry.rest.basic.PromAllocatModel;
import com.nhry.rest.basic.PromtionAddModel;
import com.nhry.service.basic.pojo.BranchScopeModel;
import com.nhry.service.order.dao.PromotionService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/promotion")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/promotion", description = "促销信息维护")
public class PromotionResource extends BaseResource {
	@Autowired
	private PromotionService promotionService;
	

	@POST
	@Path("/relBranchByPromNo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/relBranch", response = String.class, notes = "促销编号关联奶站")
	public Response relBranchByPromNo(@ApiParam(required=true,name="pmodel",value="系统参数json格式") PromAllocatModel pmodel){
		return convertToRespModel(MessageCode.NORMAL, null,  promotionService.relBranchByPromNo(pmodel));
	}
	
	

	@POST
	@Path("/promotionHasOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/promotionHasOrder", response = Response.class, notes = "根据促销编号和 奶站信息")
	public Response promotionHasOrder(@ApiParam(required=true,name="smodel",value="SearchModel") PromAllocatModel pmodel) {
		return convertToRespModel(MessageCode.NORMAL, null,promotionService.promotionHasOrder(pmodel));
	}
	

	@POST
	@Path("/getBranchsByPromNo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getBranchsByPromNo", response = Response.class, notes = "根据促销编号获取分配的奶站信息")
	public Response getAreaByBranchNo(@ApiParam(required=true,name="smodel",value="SearchModel") PromSearchModel smodel) {
		List<TMdBranch> result = null;
		if(StringUtils.isNotBlank(smodel.getPromNo())){ 
			result = promotionService.getBranchsByPromNo(smodel.getPromNo());
		}
		 
		return convertToRespModel(MessageCode.NORMAL, null,result);
	}
	
	
	@GET
	@Path("/selectPromsBySelesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/selectPromsBySelesOrg", response = TPromotion.class, notes = "获取当前销售组织下的所有促销信息")
	public Response selectPromsBySelesOrg(){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.selectPromsBySelesOrg());
	}
	
	//2017年06月19号添加
	
	@POST
	@Path("/addPromtion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/addPromtion", response = TPromotion.class, notes = "添加促销信息")
	public Response addPromtion(@ApiParam(required=true,name="smodel",value="OrderCreateModel") PromtionAddModel record ){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.addPromtion(record));
	}
	
	
	//17/06/20 

	@GET
	@Path("/searchPromoDetailByNo/{promNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchPromoDetailByNo", response = TPromotion.class, notes = "根据促销标号促销详情(多行)")
	public Response searchPromoDetailByNo(@ApiParam(required=true,name="promNo",value="商品编号") @PathParam("promNo") String promNo){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.searchPromoDetailByNo(promNo));
	}
	

	//17/06/20 

	@GET
	@Path("/delPromotion/{promNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchPromoDetailByNo", response = TPromotion.class, notes = "根据促销编号删除促销信息")
	public Response delPromotion(@ApiParam(required=true,name="promNo",value="商品编号") @PathParam("promNo") String promNo){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.delPromotion(promNo));
	}

	
	
	
	@GET
	@Path("/product/{productCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{productCode}", response = List.class, notes = "根据商品号，得到促销信息")
	public Response selectPromotionByMatnr(@ApiParam(required=true,name="productCode",value="商品编号") @PathParam("productCode") String productCode){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.getPromotionByMatnr(productCode));
	}
	
	@GET
	@Path("/promNo/{promNo}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{promNo}", response = TPromotion.class, notes = "根据促销号，得到促销信息")
	public Response selectPromotionByPromNo(@ApiParam(required=true,name="promNo",value="商品编号") @PathParam("promNo") String promNo){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.selectPromotionByPromNo(promNo));
	}


	@POST
	@Path("/selectProCreatOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/selectProCreatOrder", response = TPromotion.class, notes = "创建非年卡订单前，获取符合的促销")
	public Response selectProCreatOrder(@ApiParam(required=true,name="smodel",value="OrderCreateModel") OrderCreateModel record ){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.selectProCreatOrder(record));
	}

	@POST
	@Path("/selYearCardPromCreatOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/selYearCardPromCreatOrder", response = TPromotion.class, notes = "获取当前登录人所在的销售组织下的所有年卡信息")
	public Response selYearCardPromCreatOrder(){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.selYearCardPromBySalesOrg());
	}
	
	
	//17/06/20
	@POST
	@Path("/searchPromoByPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchPromoByPage", response = Integer.class, notes = "查询所有促销规则")
	public Response searchPromoByPage(@ApiParam(required=true,name="smodel",value="SearchModel") PromSearchModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.searchPromoByPage(smodel));
	}
	
	
	
	@POST
	@Path("/searchPromotionsByPage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchPromotionsByPage", response = Integer.class, notes = "查询所有促销规则")
	public Response searchPromotionsByPage(@ApiParam(required=true,name="smodel",value="SearchModel") OrderSearchModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.selectPromotionsrsByPage(smodel));
	}
	@POST
	@Path("/searchPromotionsByOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchPromotionsByOrder", response = Integer.class, notes = "查询订单的全部促销规则")
	public Response searchPromotionsByOrder(@ApiParam(required=true,name="smodel",value="SearchModel") PromotionOrderModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, promotionService.selectAllPromotionByOrder(smodel));
	}
}
