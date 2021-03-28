class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP,double yP, double xV, double yV, double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public  Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        double x1=this.xxPos;
        double x2=p.xxPos;
        double y1=this.yyPos;
        double y2=p.yyPos;
        double distance= Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        return distance;
    }
    public double calcForceExertedBy(Planet p){
        double m1=this.mass;
        double m2=p.mass;
        double r=this.calcDistance(p);
        double force=(6.67e-11*m1*m2)/(r*r);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double F=this.calcForceExertedBy(p);
        double dx=p.xxPos-this.xxPos;
        double r=this.calcDistance(p);
        double FbyX=F*dx/r;
        return FbyX;
    }
    public double calcForceExertedByY(Planet p){
        double F=this.calcForceExertedBy(p);
        double dy=p.yyPos-this.yyPos;
        double r=this.calcDistance(p);
        double FbyY=F*dy/r;
        return FbyY;
    }

    public double calcNetForceExertedByX(Planet[] allplanets){
        double Fnet=0;
        for(int i=0;i<allplanets.length;i++){
            if(!this.equals(allplanets[i])){
            Fnet+=this.calcForceExertedByX(allplanets[i]);
            }
        }
        return Fnet;
    }
    public double calcNetForceExertedByY(Planet[] allplanets){
        double Fnet=0;
        for(int i=0;i<allplanets.length;i++){
            if(!this.equals(allplanets[i])) {
                Fnet += this.calcForceExertedByY(allplanets[i]);
            }
        }
        return Fnet;
    }
    public double calAccelerate(double F){
        double a=F/this.mass;
        return a;
    }

    public void update(double time, double Fx,double Fy){
        this.xxVel=time*this.calAccelerate(Fx)+this.xxVel;
        this.yyVel=time*this.calAccelerate(Fy)+this.yyVel;
        this.xxPos=time*this.xxVel+this.xxPos;
        this.yyPos=time*this.yyVel+this.yyPos;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}