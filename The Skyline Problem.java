class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> points = new ArrayList<>();
        for (int bi=0; bi<buildings.length; bi++) {
            int[] b = buildings[bi];
            points.add(new Point(b[0], b[2], bi, true));
            points.add(new Point(b[1], b[2], bi, false));
        }
        Collections.sort(points, new PointComparator());
        
        List<List<Integer>> res = new ArrayList<>();
        int currH = 0;
        TreeSet<Integer> ts = new TreeSet<>(new BIComparator(buildings));
        
        for (int i=0; i<points.size(); i++) {
            Point p = points.get(i);            
            if(p.start)  ts.add(p.bi);
            else  ts.remove(p.bi);
                        
            if (i+1<points.size() && points.get(i+1).x == p.x) continue;                
						
            int newH = ts.isEmpty() ? 0 : buildings[ts.first()][2];
            if(newH != currH){
                res.add(Arrays.asList(p.x, newH));
                currH = newH;
            }
        }
        return res;
        
    }

    static class BIComparator implements Comparator<Integer> { 
        private int[][] buildings;
        
        BIComparator(int[][] buildings) {
            this.buildings = buildings;
        }
        
        public int compare(Integer bi1, Integer bi2) {
            int cmp = ((Integer)buildings[bi2][2]).compareTo(buildings[bi1][2]);
            if (cmp != 0) return cmp;
            return bi1.compareTo(bi2);
        }        
    }

    static class PointComparator implements Comparator<Point> {
        
        public int compare(Point p1, Point p2) {
            return ((Integer)p1.x).compareTo(p2.x);
        }
        
    }
    
    static class Point {        
        int x;
        int y;
        int bi;
        boolean start;
        
        Point(int x, int y, int bi, boolean start) {
            this.x = x;
            this.y = y;
            this.bi = bi;
            this.start = start;
        }       
    }
}
