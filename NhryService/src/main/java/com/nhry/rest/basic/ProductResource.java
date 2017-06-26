package com.nhry.rest.basic;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageInfo;
import com.nhry.common.exception.MessageCode;
import com.nhry.data.basic.domain.TMdMara;
import com.nhry.model.basic.ProductQueryModel;
import com.nhry.model.basic.UpdateMaraListModel;
import com.nhry.model.sys.ResponseModel;
import com.nhry.rest.BaseResource;
import com.nhry.service.basic.dao.ProductService;
import com.sun.jersey.spi.resource.Singleton;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/product")
@Component
@Scope("request")
@Singleton
@Controller
@Api(value = "/product", description = "商品信息维护")
public class ProductResource extends BaseResource {
	@Autowired
	private ProductService productService;
	
	@POST
	@Path("/{productCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/{productCode}", response = TMdMara.class, notes = "根据商品编号查询商品信息")
	public Response selectProductByCode(@ApiParam(required=true,name="productCode",value="商品编号") @PathParam("productCode") String productCode){
		return convertToRespModel(MessageCode.NORMAL, null, productService.selectProductAndExByCode(productCode));
	} 
	
	@POST
	@Path("/upt")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/upt", response = ResponseModel.class, notes = "更新商品信息")
	public Response uptProduct(@ApiParam(required=true,name="record",value="系统参数json格式")TMdMara record){
		return convertToRespModel(MessageCode.NORMAL, null,  productService.uptProductByCode(record));
	}	
	
	@POST
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/search", response = PageInfo.class, notes = "查询商品信息列表")
	public Response findProducts(@ApiParam(required=true,name="smodel",value="SearchModel") ProductQueryModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, productService.searchProducts(smodel));
	}
	
	@POST
	@Path("/searchSting")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/searchSting", response = PageInfo.class, notes = "查询商品信息列表")
	public Response searchSting(@ApiParam(required=true,name="smodel",value="SearchModel") ProductQueryModel smodel){
		return convertToRespModel(MessageCode.NORMAL, null, productService.searchSting(smodel));
	}
	
	
	
	
	@POST
	@Path("/change/status/{status}/{productCode}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/change/status/{status}/{productCode}", response = ResponseModel.class, notes = "更改商品状态")
	public Response pubProductByCode(@ApiParam(required=true,name="productCode",value="更改商品状态") @PathParam("productCode") String productCode,
			@ApiParam(required=true,name="status",value="产品状态(Y：有效；N：无效)") @PathParam("status") String status){
		return convertToRespModel(MessageCode.NORMAL, null, productService.pubProductByCode(productCode,status,true));
	} 
	
	@POST
	@Path("/lists/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/lists/{id}", response = TMdMara.class, notes = "根据价格编号查询当前组织下未被选择的商品列表")
	public Response selectProductAndExListByCode(@ApiParam(required=true,name="id",value="价格组编号(如果还没有价格组编号，直接写-1,-1表示获取当前组织下所有的产品列表)") @PathParam("id") String id){
		return convertToRespModel(MessageCode.NORMAL, null, productService.findMarasBySalesCodeAndOrg(id));
	}


	@POST
	@Path("/listsBySalesOrg")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/listsBySalesOrg", response = PageInfo.class, notes = "根据当前组织下可销售商品列表")
	public Response listsBySalesOrg(@ApiParam(required=true,name="pm",value="产品查询对象 ")ProductQueryModel pm){
		return convertToRespModel(MessageCode.NORMAL, null, productService.listsBySalesOrg(pm));
	}
	
	@POST
	@Path("/sell/lists")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/sell/lists", response = PageInfo.class, notes = "获取奶站可销售的产品清单")
	public Response getBranchSaleMaras(@ApiParam(required=true,name="pm",value="产品查询对象(branchNo(必填)、matnrTxt)")ProductQueryModel pm){
		return convertToRespModel(MessageCode.NORMAL, null, productService.getBranchSaleMaras(pm));
	}
	

	@GET
	@Path("/getProductByCodeOrName")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/getProductByCodeOrName", response = ResponseModel.class, notes = "根据产品编号或者名称模糊查询商品")
	public Response getProductByCodeOrName(@ApiParam(required=true,name="product",value="商品编号或名称") @QueryParam("product") String product){
		return convertToRespModel(MessageCode.NORMAL, null, productService.getProductByCodeOrName(product));
	}
	
	
	

	@POST
	@Path("/branch/sell/lists")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/branch/sell/lists", response = TMdMara.class, notes = "获取奶站可销售的产品清单列表")
	public Response getBranchSaleMaras(){
		return convertToRespModel(MessageCode.NORMAL, null, productService.getBranchSaleMaras());
	}
	
	
	

	
	@POST
    @Path("/updateSort")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "/updateSort", notes = "产品排序 和 隐藏  hide{Y:隐藏,N:显示}", response = ResponseModel.class)
    public Response updateSort(@ApiParam(name = "UpdateMaraListModel", value = "UpdateMaraListModel", required = true) UpdateMaraListModel UpdateMaraListModel) {
		 return convertToRespModel(MessageCode.NORMAL, null,  productService.updateSort(UpdateMaraListModel));
    }
	 
	
	
}
