   //Generating left array
        int leftArr[100001]={0};
        int rightArr[100001]={0};

        //cout<<"Left array : ";
        for(int k=0;k<i;k++){
            leftArr[k]=arr[k];
            //cout<<arr[k]<<" ";
        }
        //cout<<endl;

        //cout<<"Right array : ";
        for(int k=0;k<j-i;k++){
            rightArr[k]=arr[i+1+k];
           // cout<<arr[i+1+k]<<" ";
        }