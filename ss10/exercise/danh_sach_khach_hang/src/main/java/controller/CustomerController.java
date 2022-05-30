package controller;

import com.sun.org.apache.bcel.internal.generic.SimpleElementValueGen;
import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerController", urlPatterns = "")
public class CustomerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Customer customer = new Customer();
        Customer[]customersArr = new Customer[3];
        customersArr[0]=new Customer("trung","21/10/1999","dn", "data:image/jpeg;base64,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");
        customersArr[1]=new Customer("trung1","21/10/1999","dn","data:image/jpeg;base64,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");
        customersArr[2]=new Customer("trung2","21/10/1999","dn","data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAoHCBYWFRgWFhUYGRgaHB4cGhocHBgYHBgaGhoaGhgYHBocIS4lHCErIRgaJjgmKy8xNTU1GiQ7QDs0Py40NTEBDAwMEA8QHhISHzQrIys0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NP/AABEIAOEA4QMBIgACEQEDEQH/xAAbAAABBQEBAAAAAAAAAAAAAAAEAAIDBQYBB//EAEsQAAIBAgMEBwUEBgYHCQAAAAECAAMRBCExBRJBUQYTImFxgZEyUqGxwRRC0fAVYnKCkuEHI1Sy0/EWM1OTorPSJDRDRFVzwsPj/8QAGQEAAwEBAQAAAAAAAAAAAAAAAAIDAQQF/8QAIxEAAgICAwADAAMBAAAAAAAAAAECEQMhEjFBIjJRBHGBE//aAAwDAQACEQMRAD8AaldtN4+sk69vePrK96vGSCrI7HDhiX99vUxfaX95vUwLrYutmAGde3vH1M717e8fUwLrZ3rIbAM69vePrOGu3vH1MD62LrYAEvVNtT6xqVTbU+sHNWRpVhsA3rDzMXWHmfWC9aJzrYAF9YeZ9YuuPM+pgbVhzldX2zTBtv38Lt8oJNhZe9efePqY3r294+plLh9pIb5kZ2zFs+WfGOO1EBsXX1EOLDkW5rt7x9TI6uIb3j6mCriARrI3rC4mUaWP2hveb1MX2hvePqYF1oi60QowN+0N7x9TOfaW94+pgfWiI1BCgC/tDe8fUxde3vH1ME62c35oBfXt7x9TG9e3vH1MG6yNarMoLCDVJPtH1MkFU8z6mBI8dvwCwvrDzPrFBd+KFG2Vpxg5xq44c5n9yLclbJmh+3jnF9uHOZ3ckZWFgab7eOc5+kRzmaKTgSBtmmO0Bzi/SA5zO7kayQA0f6RHONXaAvrM4EjuqgBojtAcxIq21VUXvfuGpPKULU7ZwZ2ufzkPxmqKYWWNTF1K7bt7L7o08+Z8chLIYVKS3K77cO1p6ZXlXs7Wwy/Og4Xl/wDZjVsq7xA+8Qcu4A/WEnQ0VZX1qzhLu5AYdkd3HPwAlAxPM+Goml2xs5woFtB6+czingYRaoJJoKwGLdNCSPd1HfaXZxVwGGn5ymeRbGXuCYMvDtZEcM9Dl5fm0JIVDTtQe8I79Jj3hKzaGD3WOUDp08oUgL8bUHMTv6THMTP7k71cKQF/+lBznRtQc5Q9XHClCgL4bSHOL9IA8ZQ9VOrSvMpAaMY0c51cYDxmdWjHilCkBoftY94RTP8AUGKGgCeq7p3clz1Y5RCmOUbiLZSikZG1KXnV90b1Q5Q4mWU3U904KXdLzqhyjDTHKHELKfqzHGlLTqxfSSikIcTbKUUI/qZc9UOUayWF4UFmbx7W7PmfpAlkuKqb7E9+XhIk1/P55zVo003RHZoqVBvaD8/Sep4TZSIuSiYXoMnbyysNPG30E9LoHKceaTcjvwRSiUu0dmqwzGt/W35tPK+kOytxzu/nlPbsTSuDaYDpJg7kkjn9LQxyphljaPN6VS3ZYfgZa7PIBscw31vcfH43gO1MMUYkacRz/I+s7hq4NuXytw9PrOu7RxVTL3H0d8X1K5HvFhY9+VvQyp6u1xLrAVA/ZJ4W/Dx/POB1MKQxyMVPw1r0AKTu5Cjhm5GJaDcjCxQYJOrTha0GPA+kMw+yXY6Wg5JdsEmyrFKSJRvoJpsN0e4sZcYfZaL92Rllih1jbMZQ2Y7aLLjDdGSc2M1KUAOEkBAkpZpPoosaXZn/APRpOZnZf76xRecxuEfwzz4KdpbP5yZtp0+cQ2rT96dPORLjEcuCUcJxcOvKd/SVOx7UF/SKc4tyNaiFdQnuxn2ZeUi/Sae9GttFOcLkZSCFwiX0kwwqe7AV2inOTfpWnzmPkbomOGXlKnpEVSi5AsTkPFsvxh36VTnM/wBKccroqrqWv5AH8RGjdmOjJuIsNctkIn5QnBAhrjX8iXYiVs2HRXaITIo18uFxxP1HpPRcJiw4uvL6TzXB16+6oekNy+ThQhF7WF/vWzv3WPcd10GplkdjzsPKcmSPp24pUqDMTtdkU/1TNbllMztbHPUBPUMunEX77fCWnSapVUlUXnZj7IsLqLam5yymbwuPxjDt0xwFrbpOuYvwtu5HnrlaLBasab3Rn9qUw4vbXnkQf85m3WxuMs87c+fdPSNr4ItSDbtjbu78j6Gec44lKjjhf5zowytUc2aPF2WGBxOYI1HDQd47putlBXQNYG883otfMfzmy6P7QCISeBhljrQsGaM4VPdEkGFT3RKr9PpOHpEkhxmPcS3TCIDfdEnCASkHSKnHjpHT5xXGRqlEuhynSZSnb9LnGP0jpzOEvwOSL4PBsSZSt0nojjCMHtVK/scJvCS20ZyTCbmKO3YoUB0dEE3h2yc4q3Q9N42cjums3u0M115TrntHNfSM5SDjEyQ6IJ759Jx+iNO3tma2/evpG1Hy1X0mc5G8YmWr9Eadls9o1eiCf7QzXOMh7MQXvWHKX6HGJkz0QT3zJ8D0SpbrAtfvmlI71/PlFhMt7Ty8ocpfocY/hkv9FaQ+8ZhOk+GVKxRTcAel/wDI+k9kqtke0PSeM9JMTv4hyGBGSgjQhePqTK4W2xJpJaKUJn3zY9FNlo5u+gEydwrL4g+V8/rN5spLCUyN0GFLlsMxwUDsgADIfjNf0QpbtAd5JmOxZGV9OM0fR3a9qJsjOV+4oBY+V7fGQnqJ0pW2aTF0VaVzYBeAAhL1iwVgCBxByIvzEkWRUiqjrZktq0d0FQbg3/mPzynlO1EArNcZZZeU9h6Q07XPn6j+U8l21TzdrefgALS+B/JkP5CSiqKHesbjS/8AlLvAY6wvxtY9/wCbDzlHaE4Wpb88OInU1Zxp0z0DYmxKVagztVVLuLFiLAWbeVuTXXLPSGJ0Xw39ro/xr+MC/o6xrA1KAVXJKugYlR2d4PmAToeX3TN+tLEf7Cl/G5/+uc03JSastFRaujG/6NYb+2UP40/6pDV6M0LruYzDsbjs76KTc6DtG5m7CYjjRofxP/hwHalGoVG9Qwr2YG2+ystj7SkgZjXURVOX6a4x/DMYnotQV3BxNIAMRYugYWNs1vkY9+j+G3CRUDHuP4zXYquVd/63Cp2j7Z7WvH+sXPylfjcaGUg4rCnu3QQf+N/lMUpP0HGJ5pj8Aik2JOctejSgFgIPtE5ntQjYPtnwnVNfAhH7Gj3oo3dMU5S1s16i7rkkc65nJIBSxil17I9YaGJJO6vrBoZM6Qf1IyqDb7kfY+6vr/ORVQbeyvrMoCZgcsl0iz/UjmXTsjTnOFf1V9ZlGnL/ALE5hj7fsiwJvwGV7nuiK/qr6xuEGb9lRrqeyeyTY92U2jADGYwqjkVcKSAbBSCSeH3541iXG+7HgT5m9hPWtul1ouzU6AVVNyjNrYG+a52F/jynj2IYnPmbmWwoTIwWo1ybzd9G8Tv01PEZHxGX8/OYVhLLYO0upezHsNr+qeDeHA/ylpRtE4SqRucZiEQdojPhfM+EO2P0opqqgIezcdkEggnMmw1le6K4zz75Z7PwT2Wy3XgbgGcmS+NHo4OF/I1NDbNFwpDAFjbdbI31sL6w4CC4agAtiBn5x1SoFBJNhac9lGlfx6KDphiFVbk2styeQF854jisQzszXNmYta+Qvpl3C0239IW2TVJVckuF/atn6TBzuwRqNnB/IlcqXhyJDaIxypp6fn1lzmL/AKPVAKiMQTusAV5qx3bcs2I14Ez1inhKbC/2JyCLi7U7G/75njexXs4UkgNdTbI9oWHoc567sesXo02KYpmKje3atlB0a16osL8Jz5luy8HoKGzVOmAp/vOn0RpDj9lsU/7hh2sQbB7MLfeU9WuY8YSKN/8Ay1c/t1//ANTA9q7PBpsf0eHy0FUb/iCEJ+Mkuxn0W2JR99iFw4G8c23t495sRnAMbUfdINXB/stkD5mp9IbicKWdmGFpvfPfZgC2QzI6s/ODYnCVN0j7Lh7W0Ltn57g+YioZ9Hnm0QbnNfLTykmxPb8otqIQzAqqkE9m97d1+Mbsg2cTsl9DlX2NLvRTl4pylzlFrOCEPrLzAVSRmnxlDhwN7Rpa4ClbPdb1nRlSojBuy4t+p8ZFVU29j4zqge43rG1QPdcZznLhhGnYOnOc6s8EPrI61QA26uu2QzVVscr5EsOcgcIdaGL8n3PglUCCNYS1N/8AYsf3gPrBqN7ODRKkkruOwIcdWwyIuN07xHGRfZ0/s+M/3j/40jwipuuoWuw3nulVjvg9WvZVix7PaBBvx84Vpi+mX6c1Fp01TqKdN34qwZrCxa/YHcP3jPOXcnIeHxvL7pfX3q7KFKhAF3Sb2OrZ377TPcZ041USU3sTayNo8nMxrayghpOi+PZVKm5UHIe6LDT45TebL2ui2uwt6H4zzno8mTHmfoJqcDhyWXLjOXMts7MLdI9ATaG8OyL/AAErNp0XcHebLloP5w7ALZRJaw7J8JxW7Ozw8g6XU7AdxH4fWZVBczfdKcLfeX83mCUWax8J6eJ3E83MqkxKt4RhVyt3g+mREiRrev4j6yembEGUJILehusGH5AII9Dn4Ceo9HaoNFO3ibi4ITe3Qe4g5ZWPnPOUcOm6faGnnqB46ec1nQ7HG261R0Gh3BfNdMirHMHl92RybRWOma4qp1GNP79Uf/MQPaiU+rbeTHqAM2VnLL351IWMQn9pr/wN/hSHHYhQjEY3EoffNNiB4jqpFdjPoJxdJGa5w9R7hTvBkCm6LoC+XprBMRs5Cp/7AD4ugbyIubwp6ykJepiM0Q/1avum6LmCoGuuvGQ4hEKns41u/fe/oz/SYN4YjaVOxICFRf2Sble4nL5SHZ2TrCtpqN423yObZMfHvgWEydfGdb3E5V9jS3ike/OzmLkmGpEk23tJJSD8C8vdnUO0bvfLlJ1pqNHPpKyyiRxguDc8d+T1XGWb6yYOB98+kjq1NO3x4iRu2UXR3EV1DkdbihpklNyg7I9khDf1Mi+0p/t8Z/u6n+FJcRiwrEfbUp2t2CtPs5DK7C/+cYceP/UKPpR/6oI1jDiU/tGM/wB3V/wpW4naASk7Cu9XN1QsGR1O7T7JyB7NySbfHKWFXH5ZY+ge7dpfR5mNuV2KOzOr5+2m6AyndsCBexyBP7vPLYoVswW0WuxJvcksSdTfifHIwFBmITjd5nKqGdhqACx9Bn/lJ6Ww8USbYetewyZGXI8e0BynQmkibTbKxznG6nLU8Jd0eiuJPtU9wd5BPoD9Zb4bo4yHeKMTxNr/AC0mucf0FCX4D7Kw24qjjx8eM2myKN1BlJhsA7EBVPich6zY7KwpRArWv3TmzSVHVhiwujkJM4upHORFhpJWfunJWzpsy238Bc3trPPtr7HO8WXI8eRnsVWnvC27cd9pV4no/v8AsqB5/wAp048nEhkx8jxSqjKbMCD3zlOrbvE9TxnQy9y7LbjlfKB47obhqQVWVmqNmQWsEHKwyvw8b8s+mOSLOWWKUTD4arc9nO38Q8tT5Xmg2Niyjq6kXJuCNCRl5Hhn9Zf7P6H4ZtaYPm34w7E9BUsTRYo2tiWdSf3iSD3g+USWSPRSOJ9l3T2jcbxxVNdMiigi+uRaLFbQsjWx9FTbVkQr556Sp2LiK1ItQqbiMM7uCQeFwQQCMtfwMt8Ri33SOvwmY0YHdPcf6ySXYSVDVxI3Kd8SyXpobU0VlPZ9pSKbZG2QnKmJQg/9oxR71puLd+VMSTDu+5TtVpJ2ALIodbgkdg7x7PLWPeo9v9eT4Iij5X+MPQ8MNtZgWJ33e/3iCC3eZW4f2hrrLnbZ7ZJe58LSkp6jxnYtxOV/Yv7zsgvFOeix6DQJ3mzTTUThc++n58p2gli3YA85xl/UX1/nJFBpc++n58pFUcm3aQ5/nhHlP1E9f5yKoma9hdeB/nAGE1qtUE7tTDqvAOjb2nE9YL+kZ1lb38KfJ/8ArMVempOdJG/aCn5wZsKDpg8O3iyg+nVn5zUBFtGpVAG99n46b/nxgmB2OKoBdFHa3iq3AJvcE+g9JFiUXrQvUU6ZXJtyxuTY5sFXhbK3OaPAmwhLSHhG3sZT2WqjcRVUHLIAe0bXy8ZLtVAXY+XoIVSqAui82v8Awgt8wPWVuMxG8zHmSfWKloo3v/CsFAlu6GCgLSNNYSt5sgQFUFjCqTEzr0JJTS0xtNGq7JEQRzRrRok6Hsehkga0YgkeLqbqkjyHMnICaZZ2m4dzf2KY335FtUX1G8f2bcZlsUxeoztqT8OAmrfDdXSWn95u255seHy9O+Uz4azS0ZKOiLi5bJdnZS+w+cp6CWlrhjJydlI6BtuYIOm8Fu6XZe+w7S+Y+IHKVFJnKABMOQwNt4ndNvu3tpxHd4TUvpPNziFpK6mmhKO6XsN6yuwXPXS0Me9E82lZpcHcUkG4iWBG6p3lXtGwU8RJGc819P5Sq2Pjg6DsgeMJxuJ3FvZY7WySaoz+3D2vaXylDfPXjLza771jZc+UojrqJ1xfxOaX2LDeMUi3p2Toez0rDqO32W8CZxkHuN6xYd1s3bY5+caxX3nnOXOFB7jeshdRvL2GGfMyVivvPISV3l7TTUDCKii/sMfOQvTU6oxEfV3bnN4FtBwtNyC97WHich84IGVWBILkgWBNwOQJyE0lKvYTNYE2ndo7Qsu6D49/dGkrdDwdIvNm47eeo/3adNgP2mNgYPTr7xgOz3Iw7ge1UdR+6oLE/wAVodszA7wuXAF7aR/+brSE5q9h1FYUqR9PAlfvA+X4Xk4om2mXdnJSjJFYyi+mCOsS5Ql0ygFZzooJPIC5k1sfo69SdQyJcKy51XWmORO838K/jHpWRjupvXtq1s/ADT1lVik1dEnlivQtFj8Phw1UX9mmN5u9vujyzPpC9jYYNSu4uSzHU9y8P2ZYphkClQN0Nmbc8s8/AQUKZjypoosR2iTzgGJS2fITQVtnMM1Ibu0Mpdp9lHvkQra8MjIyTi9l4SjJaB8O1xLCjKbZbG0t6cGaGXynmnSLCFMTUP3WYN/Eov8AG89JU5Tz/p24SsrHig+DN+MMbqRPOrgQUKop52v3SOvtgON3dtcwLD4wVMhyldX7DZayy2cDk0qLKuw0GZgxQaAaawfDVM2djFQqHMtkNZS2hGFb/dFB/wBJJOTOTNs9ZpE7p7SjPUTjE++PSZ5ekgUexfunR0rU/wDhfKJxZ1KSLxmPv/CRMx3l7YPlKlek6n/wx8Im6RKbdgTOLDki5qMb+38JV7bqf1ZG/e5Atz4/SRN0kX3BAdo7UFYKoQLY38ciB8zNjF2gbRBTewg1envui3tne/cLk/K3nJV0jUQ76nhn45g8J0RjbFlKkXOAolmCKpIGoHLvPCavB4VVTda1+AGijkSdTr6ztLZS08Oh3ghtdyb9otn520EhweD6zMMxG9a/sjdGptfjHlO+uiUVRa0kW31GUYQQ2QOtvkRLJrMoKgMuQtp6cpDTHaYciPI7oyPPWRsdFfj6yqA27vC18uPfflKirjHK3VQi6XGV/Dix8J3GBt7c3bBXfdyvqb25ZX484JiXNt7NzpvHQdw/No8eK82ZJyfuifC7LeoN7eA7znf8JzC4YpU3WFiMp0YOolNa6tk2oufK4koxTOVvnbQ8RNc27RiSWzTYJbUkt3/EkwkjSC7Lq7yW9029cx+e6FXkhhSi6X4ZXw7jeCsbBCeJJHZPdL+YjpM7PX6sE2BGXIABmImKPLTNTraIsHhSircggjIi+drX1A5j1lmkEw2K3l3CpNtCNRpn8R6y0pKmQGY7PaIIvqWOelgPiJKUGmdMcia2NXSYD+kenco3IEfETfDw4kenfMJ/SHXAKKeKt8CPxk4qpG5mnjbRkdnOA3LnBcfUu5schA0xFr3jUqDOWUWrPPCVrG1o+o5OV4NQpsdJxwQeM3rVmUP3O6KRb574pu/0KNqbSO8hoV75GOrVLa6c4Irdqx5nGMrlxwuRe8lOKjUHJBBfMAZkmw7ydBLfDbPK5vkOFs7+ekosBi9yqGtcN2RqSpbK4A1PDzmqRC3ZYmwztwHd+ectjgmJKTXRA2E3Sb2IBy7/ABkmEo79VL5Dez8OPwvHVgL/AJyjab2IIy/NvxllBLoVybNHtHHNVYKul91V+AmipIKNNFGunnqx/PEiU3RjAb7da2gyXvPEyypYjra9/ug7q+C5s3mbfwznyPxeFIr1lhhqKqAALX4D684DtXbCUju2u5yUcB4+oy75PjsWEN/PymWxNTfcsdQGPm1h+MSMb/oZui22W5qiqW7VrNyz42t4fASoZGZwt73Nh3Xln0bqbqVrahb+gaTdHsESesYZfd/GV0mxe6LfGYYdQU4BRbysR8pnsPhbODwF7+k1eJTeUgSgx53FPA8JO60alZPsR/a7wD6f5y03pRbCfMj9U/MS6DRHoYmBlCCWx2ZG6iEAWGZYAm51Op9Zdq0yWCxV6+/77sfImw+AE1dAkFU6XV1nTRWNxwyYEZeGnlCqVYHsMti41GVjmG+IPpJNoIMt+9xow4E8PDSDUG/ryp4ZjxcBj9ZjYx1KLDsZX4E6HkfThzmX6d7EZxvod/qlO+v3rZXdeYFsxwGfhsqFS5IOqnLwOv57oHthzTJrb1kyDN7hyUXsL7pyz4cZNxT2M22uPh4Di6HlH7OwQcMSbAS26Q7jPU6sWRXbd/Zvlbu5d0A2JmXByBlF0c/HYNiwaTZNqI6nVDjvh2K2cWa972gyYZQ3IjWFJ9GNM5uNyihX2gc4ocWLosEqDWJsTla8jXdIJEiZEYa2ImpD7QBidy5IurfAwdWa+Rhj0Q2W/GNs82uCI6ZJpt6LzonhizNUcZJkvex/Af3hNZTUhb8TmfOAbIwfV0aaH2iN5/FsyPLTylgz2JBnTFcUAO8lwOFLuiD7xtfkOMicy76LUb1VPIGEpUmxkujTYk9XRCILEjdHcOJ/POD7FQB8uAt+MJ2uLW8D88/pB9iak985PLLAe1q+8zX529MpnmrWe3dbzOnyEv8AblPdqHk3aHnr8bzJ4pu2T4fKOuhfSzw1Yo4Nzbj3ibvANdAZ57h33rH83mx2Ridxd06cO7+UJ0ai8Uyp21SBQnkb/SWgeA7WQtTYDM5eOsRAVGx0zZ+AFh56/KW6tB6VIIirfTXxNr/nuMkNZRc5/j3/AFk5O2US0M2tXKUHI13bDxbs/WZfc3HQcgLelrwjbu2N91opoHG94g2t852rT30DL7SGxHMHP4fWPHoC72i4ehv9wPrlKhqhFVG5oh+JX5CGUKm9hn/V+jBvlAa67xS2oBU93auPmZhqLXF9khx3XhARXR0cXVt5SOasCD8zIcRmludvnCE+YHyt9IjZp4ltmhuVnRh2kYo3C5U23vA6+cDw2GO8SB2eM0/9J2B3MSKii3WIGvzZOww9AnrMls/Hva1/KYrXRJtXsIFcAm2ukDqjtZamTuy73aFifjOV3CEvbTSENWLLaOfZYpF+kxyilBKQ7Qa2g5uNDrIHqZ6x7G4BlSTkQMGF7S36P0nesiG9r7x/ZXMjz085XU1zz1mo6FUDeo7cLIP7zfJPWbGNyBM1iZsTykeIktIZeMbX0nQykQMtaanobYsW8vOZJ4fs3aL4Zg65+8p0YcvHvk5J8WOns3m11JIA5QTZTkOVtY2zi2ft2jiVUq2617FGyII1AOh8ocyBHZuYHwnOxyv6RLcKcrgN6C1vj85gMbWYOQqjK2eZ4A/Cbbbrk2B1bPwUaDzIv5TF13O+9veI+QPytNV0Cqw/Zd+yXFjvZ5WsMpszhrjKZGixZQx43+ZvNDsivZQrG3uk6a6RZdGrsscO7obNe3A/jGbT2wiMKe9ZjqfdGufefr3wlHuHzF1GfHgbfLSC1cEjmzAEtzGeRI159oDyiNjJWQrVZ7lSCNbjPIEksPIj4jjAtsVdxGsbnesMsu0WHHgAoEIXZapnTdlv2rXNip7VtMhZTM/tus5dkbPdPDQ5mxt4EfGEVbNbpFdhnJqAnM5n/hvf1lth8UVNwfEc5RUWKupPMA+eV/jLFlvmMpRrZkXo1+yt1kK8GGY8ciJVYimyPnw48xF0exdn3W46S62phd7OIagbDVQyw5B2V8JR0yUbPQi1++2Uu8M91EVgzG/0o0L4ZKls6dSxPJaim/xVJ5NRO6+ehntfT9L4Jx+sn/MWeO4lVQ2bMce6NF6IzeyLEVr56kRmIxBcheHGS0lVmNjcEZRlZFQ98NIW7JNxOU7Beu7j8JyBtkAhMUUsc45PbE2nRP8A1L/+439xIoo+P7AjRL7I8JDXiiln2VQGNYsX7Jiiiy+oy7G7K/1X77f3p6Fgfz8IopzsougPb3tL+zMNX9tvFp2KYujC3w3sL5/My6p+wn7B/vvFFFn0NHstdk6v4fUyWlqvl8zFFJsddsZU0T9gf3Xma277f7v1M7FNh2ZLozlX2h4j5iHpq354xRSrMiF4L218R85tsR7I8IopN9mlHi/ZMsMD7HnORRWaym6f/wDcn/aT/mLPG9qanyiimxIZOyPZf1ix3DxnYpvoiB4ooppp/9k=");
        request.setAttribute("listCustomer",customersArr);
        request.getRequestDispatcher("tran.jsp").forward(request,response);
    }
}
