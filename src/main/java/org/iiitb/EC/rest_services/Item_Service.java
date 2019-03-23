package org.iiitb.EC.rest_services;

import java.sql.Connection;
import java.util.ArrayList;

import org.iiitb.EC.dao.DAO_Buyer;
import org.iiitb.EC.dao.DAO_Item;
import org.iiitb.EC.dao.DAO_Seller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.iiitb.EC.dbcon.DatabaseConnection;
import org.iiitb.EC.model.Buyer;
import org.iiitb.EC.model.Item;
import org.json.JSONArray;
import org.json.JSONObject;

@Path("itemService")
public class Item_Service {
	private static final String SUCCESS_RESULT="Success";
	private static final String FAILURE_RESULT="Failure";	
	
	public int get_seller_id(HttpHeaders httpheaders) {
		String username = httpheaders.getHeaderString("username");
		return DAO_Seller.get_seller_id(username);
	}
	
	
	
	@Path("itemsTop")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
	 public String getTopItems() throws Exception{
		
		ArrayList<Item> items = DAO_Item.get_Top5_Items();
		JSONArray item_json_array = new JSONArray();
		for(Item item : items) {
			JSONObject item_json = new JSONObject();
			item_json.put("item_id", item.getItem_id());
			item_json.put("description", item.getDescription());
			item_json.put("name", item.getName());
			item_json.put("pic_location", item.getPic_location());
			item_json.put("category", item.getCategory());
			item_json.put("sub_category", item.getSub_category());
			item_json.put("barcode", item.getBarcode());
			item_json.put("price", item.getPrice());
			item_json.put("discount", item.getDiscount());
			item_json_array.put(item_json);
		}
		JSONObject result = new JSONObject();
		result.put("items", item_json_array);
		return item_json_array.toString();
	}
	
	@Path("itemsDiscounted")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
	 public String getDiscountedItems() throws Exception{
		
		ArrayList<Item> items = DAO_Item.get_Top5_Discounted();
		JSONArray item_json_array = new JSONArray();
		for(Item item : items) {
			JSONObject item_json = new JSONObject();
			item_json.put("item_id", item.getItem_id());
			item_json.put("description", item.getDescription());
			item_json.put("name", item.getName());
			item_json.put("pic_location", item.getPic_location());
			item_json.put("category", item.getCategory());
			item_json.put("sub_category", item.getSub_category());
			item_json.put("barcode", item.getBarcode());
			item_json.put("price", item.getPrice());
			item_json.put("discount", item.getDiscount());
			item_json_array.put(item_json);
		}
		JSONObject result = new JSONObject();
		result.put("items", item_json_array);
		return result.toString();
	}
	
	@Path("checkitem")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
 public static String checkItemExist(@FormDataParam("Barcode") String barcode) throws Exception{
        
 
        int exist = DAO_Item.Check_Item(barcode);
        
        JSONObject obj = new JSONObject();
        obj.put("item_id", exist);
        return obj.toString();
                
     }
	
//	@Path("getitem")
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
// public static String getItem(String item_j) throws Exception{
//        
// 		JSONObject item_json = new JSONObject(item_j);
//        int item_id = Integer.parseInt(item_json.getString("item_id"));
//        Item item=DAO_Item.Get_Item(item_id);
//        
//        JSONObject obj = new JSONObject();
//        obj.put("name", item.getName());
//        obj.put("description", item.getDescription());
//        obj.put("price", item.getPrice());
//        obj.put("discount", item.getDiscount());
//        obj.put("pic_location", item.getPic_location());
//        obj.put("category", item.getCategory());
//        obj.put("sub_category", item.getSub_category());
//        obj.put("dummy_1", item.getDummy_1());
//        obj.put("dummy_2", item.getDummy_2());
//        obj.put("dummy_3", item.getDummy_3());
//        obj.put("dummy_4", item.getDummy_4());
//        return obj.toString();
//                
//     }
	
	
	@Path("getitem")
    @GET
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
 public static String getItem(
		 @FormDataParam("item_id") String item_id_str ) throws Exception{
        
        int item_id = Integer.parseInt(item_id_str);
        Item item=DAO_Item.Get_Item(item_id);
        
        JSONObject obj = new JSONObject();
        obj.put("name", item.getName());
        obj.put("description", item.getDescription());
        obj.put("price", item.getPrice());
        obj.put("discount", item.getDiscount());
        obj.put("pic_location", item.getPic_location());
        obj.put("category", item.getCategory());
        obj.put("sub_category", item.getSub_category());
        obj.put("dummy_1", item.getDummy_1());
        obj.put("dummy_2", item.getDummy_2());
        obj.put("dummy_3", item.getDummy_3());
        obj.put("dummy_4", item.getDummy_4());
        return obj.toString();
                
     }
	
	
		
	
	@Path("addItem")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String addItem(
			@FormDataParam("item_name") String name,
			@FormDataParam("item_barcode") String barcode,
			@FormDataParam("item_description") String description,
			@FormDataParam("item_price") String price,
			@FormDataParam("item_discount") String discount,
			@FormDataParam("item_pic_location") String pic_location,
			@FormDataParam("item_category") String category,
			@FormDataParam("item_sub_category") String sub_category,
			@FormDataParam("item_quantity") String quantity,
			@FormDataParam("item_address") String address,
			@FormDataParam("item_dummy_1") String dummy_1,
			@FormDataParam("item_dummy_2") String dummy_2,
			@FormDataParam("item_dummy_3") String dummy_3,
			@FormDataParam("item_dummy_4") String dummy_4,
			@Context HttpHeaders httpheaders) throws Exception{
		
		int seller_id = get_seller_id(httpheaders);
		
		boolean result = DAO_Seller.add_item(seller_id,name, barcode, description,Float.parseFloat(price),Float.parseFloat(discount),pic_location,category,sub_category,Integer.parseInt(quantity),Integer.parseInt(address),dummy_1,dummy_2,dummy_3,dummy_4);
		return result ? SUCCESS_RESULT : FAILURE_RESULT;
	}
	
	@Path("addQuantity")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String addQuantity(
	  @FormDataParam("item_barcode") String barcode,
	  @FormDataParam("item_quantity") int quantity,
	  @Context HttpHeaders httpheaders) throws Exception{
		
		int seller_id = get_seller_id(httpheaders);
		
	 boolean result = DAO_Seller.add_quantity_to_existing_item(seller_id,barcode, quantity);
	 return result ? SUCCESS_RESULT : FAILURE_RESULT;
	}
	
}