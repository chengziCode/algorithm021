
// 11 盛最多水的容器
public class MaxArea {

    //关键在于指针的移动

    public int maxArea(int[] height) {
        int startIndex = 0; //首坐标
        int endIndex = height.length - 1; //尾坐标
        int maxArea = 0; //最大面积
        while (startIndex != endIndex) {
            maxArea = height[startIndex] > height[endIndex] ?
                    Math.max(maxArea, getArea(height, startIndex, endIndex--)) :
                    Math.max(maxArea, getArea(height, startIndex++, endIndex));
        }

        return maxArea;
    }

    public int getArea(int[] height,int startIndex, int endIndex) {
        return (endIndex - startIndex) * Math.min(height[startIndex], height[endIndex]);
    }
}
