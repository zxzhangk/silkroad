package com.silk.msg;

public class CommonResponse
{
	/**
	 * 返回码
	 */
    private int code;
    
    /**
     * 消息
     */
    private String msg;
    
    public static CommonResponse genSuccess(String msg)
    {
    	CommonResponse res = new CommonResponse();
    	res.setCode(200);
    	res.setMsg(msg);
    	return res;
    }
    
    public static CommonResponse genFail(String msg)
    {
        CommonResponse res = new CommonResponse();
        res.setCode(400);
        res.setMsg(msg);
        return res;
    }

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}
    
    
}
