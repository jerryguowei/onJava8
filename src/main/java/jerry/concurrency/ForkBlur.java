package jerry.concurrency;

import java.util.concurrent.RecursiveAction;

public class ForkBlur extends RecursiveAction {
	private int[] mSource;
	private int mStart;
	private int mLength;
	private int[] mDestination;
	protected static int sThreshold = 100000;

	
	private int mBlurwidth = 15;
	
	public ForkBlur(int[] src, int start, int length, int[] dst) {
		mSource = src;
		mStart = start;
		mLength = length;
		mDestination = dst;
	}
	
	protected void computeDirectly() {
		int sidePixels = (mBlurwidth - 1) / 2;
		for(int index = mStart; index < mStart + mLength; index++) {
			float rt = 0, gt = 0, bt =0;
			for(int mi = -sidePixels; mi <= sidePixels; mi++) {
				int mindex = Math.min(Math.max(mi + index, 0), mSource.length -1);
				int pixel = mSource[mindex];
				
				rt += (float)((pixel & 0x00ff0000) >> 16) / mBlurwidth;
				
				gt +=(float)((pixel & 0x0000ff00) >> 8) / mBlurwidth;
				
				bt +=(float)((pixel & 0x000000ff) >> 0) / mBlurwidth; 
			}
			
			int dpixel = (0xff000000 ) | (((int)rt) << 16) | (((int)gt) << 8 ) | (((int)bt) << 0);
			mDestination[index] = dpixel;
		}
	}
	
	@Override
	protected void compute() {
		if(mLength < sThreshold) {
			computeDirectly();
			return;
		}
		
		int split = mLength / 2;	
		invokeAll(new ForkBlur(mSource, mStart, split, mDestination),
				  new ForkBlur(mSource, mStart + split, mLength - split, mDestination));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
