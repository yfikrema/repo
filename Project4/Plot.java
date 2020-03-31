package application;
/**
 * 
 */


/**Represents a Plot object 
 * 
 * @author Yared Fikremariam
 *
 */

public class Plot {

	
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 *  No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	
	Plot()
	{
		x=0;
		y=0;
		width=1;
		depth=1;
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p
	 */
	Plot(Plot p)
	{
		this.x=p.x;
		this.y=p.y;
		this.width=p.width;
		this.depth=p.depth;
		
	}
	
	/**
	 *  Parameterized Constructor
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	
	Plot(int x,int y,int width,int depth)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
		
		
	}
	
	
	/**
	 *  determines if this plot overlaps the parameter,
	 *  returns true if the two plots overlap, false otherwise 
	 * @param plot
	 * @return
	 */
	
	  public boolean overlaps(Plot plot)

      {

            if((((x>plot.x && x < (plot.x+plot.width)) && (y >plot.y && y < (plot.y+plot.depth))) ||

              (((x + width)>plot.x && (x+width) < (plot.x+plot.width)) && (y >plot.y && y < (plot.y+plot.depth))) ||

              ((x>plot.x && x < (plot.x+plot.width)) && ((y +depth) >plot.y && (y+depth) < (plot.y+plot.depth))) ||

              (((x+width)>plot.x && (x+width) < (plot.x+plot.width)) && ((y+depth) >plot.y && (y+depth) < (plot.y+plot.depth))))||
              ((x<plot.x)&&(plot.x<(x+width)))||(y<plot.y&&plot.y<y+depth)||
              (x==plot.x&&x+width==plot.x+plot.width)&&y==plot.y&&y+depth==plot.y+plot.depth)

     

                   return true;

           

            else if((((plot.x>x && plot.x < (x+width)) && (plot.y >y && plot.y < (y+depth))) ||

                   (((plot.x + plot.width)>x && (plot.x+plot.width) < (x+width)) && (plot.y > y && plot.y <(y+depth))) ||

                   ((plot.x>x && plot.x < (x+width)) && ((plot.y +plot.depth) > y && (plot.y+plot.depth) < (y+depth))) ||

                   (((plot.x+plot.width)>x && (plot.x+plot.width) < (x+width)) && ((plot.y+plot.depth) > y && (plot.y+plot.depth) < (y+depth)))||
                   (plot.x<x)&&(x<plot.x+plot.width))||(plot.y<y&&y<(plot.y+plot.depth)))

                   return true;

           

            return false;

           

           

      }
	


	/**
	 *  takes a Plot instance and determines if the current plot contains it. 
	 * @param plot
	 * @return
	 */
	
	public boolean encompasses(Plot plot)
	{
		
		//if((plot.x>=this.x)&&((plot.x+plot.width)<=(this.x+this.width))&&(plot.y>=this.y)&&((plot.y+plot.depth)<=(this.y+this.depth)))
		if((this.x<=plot.x)&&((plot.x+plot.width)<=(this.x+this.width))&&(this.y<=plot.y)&&((plot.y+plot.depth)<=(this.y+this.depth)))
		{
			
			return true;
		}
		
		
		return false;
		
	}
	
	
	/**
	 * sets the x value
	 * @param x
	 */
	
	public void setX(int x)
	{
		this.x=x;
		
	}
	
	/**
	 * sets the y value
	 * @param y
	 */
	public void setY(int y)
	{
		this.y=y;
		
	}
	
	/**
	 * sets width
	 * @param width
	 */
	public void setWidth(int width)
	{
		this.width=width;
		
	}
	
	/**
	 * sets depth
	 * @param depth
	 */
	public void setDepth(int depth)
	{
		this.depth=depth;
		
	}
	
	/**
	 * returns the x value
	 * @return
	 */
	public int getX()
	{
		return x;
		
	}
	
	/**
	 * returns the y value
	 * @return
	 */
	public int getY()
	{
		return y;
		
	}
	
	/**
	 * returns the width
	 * @return
	 */
	public int getWidth()
	{
		return width;
		
	}
	
	/**
	 * returns the depth
	 * @return
	 */
	public int getDepth()
	{
		return depth;
		
	}
	
	/**
	 * Prints the X,Y of the upper left corner, the width and the depth. 
	 */
	public String toString()
	{
		
		return "Upper left: ("+this.x+","+this.y+"); Width: "+this.width+" Depth: "+this.depth;
	}
}
