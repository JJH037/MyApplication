package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;



//추가
import net.daum.mf.map.api.MapPolyline;
import android.graphics.Color;
import net.daum.mf.map.api.MapCircle;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapPolyline;
import net.daum.mf.map.api.MapView;
import net.daum.mf.map.api.MapPOIItem;
import java.lang.Integer;
import java.lang.Integer;
import  com.example.myapplication.*;
import java.util.HashSet;
import java.util.Stack;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





public class dij extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dij);
        for(int k=1;k<3;k++) {
            System.out.println("Hello, World~!!.");

        }






        try {
            PackageInfo info=getPackageManager().getPackageInfo("com.example.myapplication", PackageManager.GET_SIGNATURES);
            for(Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.2334, 129.0784), 2, true);






        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(35.2334, 129.0784));










        Button imageButton_back = (Button) findViewById(R.id.btn_back);
        imageButton_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                MainActivity.Pair tmp = new MainActivity.Pair(3.23, 403.3211);
                System.out.println("Hello, Worldaaaaaa.");
                // MainActivity.Pair tmp = new MainActivity.Pair(3,3);

                //MainActivity.Mapstack.pop();
                MainActivity.Mapstack.add(tmp);



                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }



//Mapstack.push(1);


    public static class Edge2  {
        double latitude,longitude;
        String struct_name;
        int id;

        public Edge2( double latitude, double longitude, String struct_name){
            this.latitude=latitude;


            this.longitude=longitude;
            this.struct_name = struct_name;
        }


    }


    static class Edge  {
        int v, weight;


        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;

        }




    }


    static public int maps[][];





    public static void main(String[] args) {
        //  Scanner sc = new Scanner(System.in);
        int V =10;
        //sc.nextInt();
        int E = 10;
        // //sc.nextInt();
        List<Edge>[] adj = new ArrayList[V];


        for(int k=1;k<3;k++) {

            //MainActivity.Pair tmp = new MainActivity.Pair(lat1[k], lon1[k]);
            System.out.println("Hello, World.");
            // MainActivity.Pair tmp = new MainActivity.Pair(3,3);

            //MainActivity.Mapstack.pop();
            //    MainActivity.Mapstack.add(tmp);
        }

        //  List<Edge2>[] adj2 = new ArrayList[V];



        for (int i = 0; i < V; i++){
            adj[i] = new ArrayList<>();
            for (int j = 0; j < E; j++) {
                // 첫번째가 출발지, 두번째가 도착지, 세번째가 가중치ㅋ
                if(i==j){

                    maps[i][j]=0;
                    adj[i].add(new Edge(0, 0));
                }
                else{
                    maps[i][j]=Integer.MAX_VALUE;
                    adj[i].add(new Edge(j, Integer.MAX_VALUE));
                }

            }

        }

        maps[1][2]=88;
        maps[2][1]=88;
        adj[1].add(new Edge(2, 88));
        adj[2].add(new Edge(1, 88));



        maps[1][3]=96;
        maps[3][1]=96;
        adj[1].add(new Edge(3, 96));
        adj[3].add(new Edge(1, 96));


        maps[2][4]=132;
        maps[4][2]=132;
        adj[2].add(new Edge(4, 132));
        adj[2].add(new Edge(4, 132));

        maps[4][3]=75;
        maps[3][4]=75;
        adj[3].add(new Edge(4, 75));
        adj[4].add(new Edge(3, 75));

        maps[4][5]=179;
        maps[5][4]=179;

        adj[4].add(new Edge(5, 179));
        adj[5].add(new Edge(4, 179));

        MainActivity.adj2[1].add(new Edge2(35.23046,129.08256, "제6공학관"));
        MainActivity.adj2[2].add(new Edge2(35.23129,129.08288,"넉넉한터"));
        MainActivity.adj2[3].add(new Edge2(35.23081,129.08159,"토조실험실"));
        MainActivity.adj2[4].add(new Edge2(35.23157,129.08143,"인문관"));
        MainActivity.adj2[5].add(new Edge2(35.23313,129.08216,"제11공학관"));


        double lat1[] = new double[42];
        double lon1[] = new double[42];;

        lat1[1]=35.23046;lon1[1]=129.08256;
        lat1[2]=35.23129;lon1[1]=129.08288;
        lat1[3]=35.23081;lon1[1]=129.08159;
        lat1[1]=35.23157;lon1[1]=129.08143;
        lat1[1]=35.23313;lon1[1]=129.08216;

        //
        // dijkstra
        PriorityQueue<Edge> pq = new PriorityQueue<>();



/*

        Edge[] D = new Edge[V];
        // 0번에서 출발하는걸로.
        for (int i = 0; i < V; i++) {
            // 원하는 출발지
            if (i == 1) {
                D[i] = new Edge(i, 0);
            } else {
                D[i] = new Edge(i, Integer.MAX_VALUE);
            }
            pq.add(D[i]);
        }


 */


        //
/*

 int n = 5;
int start = 1;
int dest = 5;



        boolean[] check = new boolean[n+1];

        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
        for(int i=1;i<n+1;i++){
            if(i==start){
                distance[i]=0;
            }
            else if (distance[i]>maps[start][i]) {
                distance[i] = maps[start][i];
            }
            else{

                distance[i]=Integer.MAX_VALUE;
            }

        }

        for(int k=1;k<3;k++) {

            MainActivity.Pair tmp = new MainActivity.Pair(lat1[k], lon1[k]);
            System.out.println("Hello, World.");
            // MainActivity.Pair tmp = new MainActivity.Pair(3,3);

            //MainActivity.Mapstack.pop();
            MainActivity.Mapstack.add(tmp);
        }
*/








        //   dfs();


/*

        for(int k=0;k<n-1;k++){
            int min=Integer.MAX_VALUE;
            int min_index=-1;

            //최소값 찾기
            for(int i=1;i<n+1;i++){
                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
                    if(distance[i]<min ){
                        min=distance[i];
                        min_index = i;


                        MainActivity.Pair tmp = new MainActivity.Pair(lat1[next.v] , lon1[next.v]);

                        // MainActivity.Pair tmp = new MainActivity.Pair(3,3);

                        MainActivity.Mapstack.pop();
                        MainActivity.Mapstack.add(tmp);


                    }
                }
            }

            check[min_index] = true;
            for(int i=1;i<n+1;i++){
                if(!check[i] && maps[min_index][i]!=0){
                    if(distance[i]>distance[min_index]+maps[min_index][i]){
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }

        }
*/



/*

        for(int i=1;i<n+1;i++){
            if(!check[i] && maps[dest][i] !=0){
                distance[i] = maps[dest][i];
            }
        }



        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            for (Edge next : adj[edge.v]) {
                // check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
                if (!check[next.v] // 1.2면 1에서 2의 체크
                        && D[next.v].weight > D[edge.v].weight + next.weight) {
                    D[next.v].weight = D[edge.v].weight + next.weight;
                    // decrease key
                    pq.remove(D[next.v]);
                    pq.add(D[next.v]);


                   MainActivity.Pair tmp = new MainActivity.Pair(lat1[next.v] , lon1[next.v]);

                   // MainActivity.Pair tmp = new MainActivity.Pair(3,3);

                    MainActivity.Mapstack.pop();
                    MainActivity.Mapstack.add(tmp);

                }
            }



            check[edge.v] = true;
        }
*/


        // System.out.println(Arrays.toString(D));
    }



    /*
    private static void dfs(int v) {
        int n = a.length-1;

        for(int i=1; i<=n; i++){

            //v->i갈 수있는 길이 있고, 방문하지 않은 경우
            if(a[v][i]==1 && c[i]==0){
                c[i] = 1; // 방문체크
                dfs(i);
            }
        }


    }

     */








}



