/**
 * The purpose of this class is to model a television
 * @author Yared Fikremariam 03/08/2020
 *
 */




public class Television {

	private String MANUFACTURER;  
	private int SCREEN_SIZE;
	private boolean powerOn;
	private int channel;
	private int volume;
	
	/**Constructor initializes MANUFACTURER,SCREEN_SIZE powerOn
	 * volume and channel
	 * 
	 * @param brand The brand of the television
	 * @param size The size of the screen
	 */
	
	public Television(String brand,int size)
	{
		MANUFACTURER=brand;
		SCREEN_SIZE=size;
		powerOn=false;
		volume=20;
		channel=2;
		
		
		}
	
	/**Sets channel 
	 * 
	 * @param station The station 
	 */
	public void setChannel(int station)
	{
		channel= station;
		
	}
	
	/**Turns power on or off
	 * 
	 */
	public void power()
	{
		powerOn=!powerOn;
		
	}
	/**Increases volume by one
	 * 
	 */
	public void increaseVolume()
	{
		volume+=1;
	}
	/**Decreases volume by one
	 * 
	 */
	public void decreaseVolume()
	{
		volume-=1;
	}
	/**Gets the channel
	 * 
	 * @return The channel
	 */
	public int getChannel()
	{
		return channel;
		
	}
	/**Gets the volume
	 * 
	 * @return The volume
	 */
	public int getVolume()
	{
		return volume;
	}
	/**Gets the Manufacturer's name
	 * 
	 * @return The name of the brand
	 */
	public String getManufacturer()
	{
		return MANUFACTURER;
		
	}
	/**Gets the screen size of the television
	 * 
	 * @return The size of the screen
	 */
	public int getScreenSize()
	{
		return SCREEN_SIZE;
		
	}

}
