public class MaxMinTournamentMethod {
    static class MinMax{
        int min;
        int max;
    }
    static MinMax getMinMax(int[] arr, int low, int high){
        MinMax minMax = new MinMax();
        MinMax lmm = new MinMax();
        MinMax rmm = new MinMax();

        if(low == high){
            minMax.max = arr[low];
            minMax.min = arr[low];
            return minMax;
        }
        if (high == low+1){
            if(arr[low]>arr[high]){
                minMax.max = arr[low];
                minMax.min = arr[high];
            }else {
                minMax.max = arr[high];
                minMax.min = arr[low];
            }
            return minMax;
        }
        int mid = (low+high)/2;
        lmm = getMinMax(arr,low,mid);
        rmm = getMinMax(arr,mid+1,high);
        if(lmm.min < rmm.min){
            minMax.min = lmm.min;
        }else {
            minMax.min = rmm.min;
        }
        if(lmm.max > rmm.max){
            minMax.max = lmm.max;
        }else {
            minMax.max = rmm.max;
        }
        return minMax;
    }

}
